package com;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;
import edu.wpi.first.wpilibj.tables.ITable;


/**
 * @author Adam Raine
 * We use this class to use an analog signal that provides information about the
 * angle of a shaft, and use it to determine the position of the shaft.
 * 
 * By noticing when the analog signal has a large dropoff, it is possible to
 * accumulate the cycles of the analog signal into one, continuous function
 * for the position of a shaft.
 */
public class AnalogAbsoluteEncoder implements Runnable, PIDSource, LiveWindowSendable {
	
	private boolean running = true;
	private boolean inverted = false;
	private AnalogInput ai;
	private double offset;
	private volatile double realDistance;
	private volatile double realRate;
	private double lastVoltage;
	private int cycles;
	private PIDSourceType pidSource = PIDSourceType.kDisplacement;
	private final double ANALOG_RANGE = 4.972; //Max voltage: 4.987 subtract min voltage: 0.015
	private ITable table;
	
	public AnalogAbsoluteEncoder(int channel) {
		ai = new AnalogInput(channel);
		//To get a more accurate reading, the code averages 4 samples from the
		//analog channel in each iteration.
		ai.setAverageBits(0);
		ai.setOversampleBits(0);
		zero();
		//This process must continue throughout the match, therefore it must
		//be run continuously in a separate thread than the scheduler.
		new Thread(this, "Analog Absolute Encoder Thread").start();
	}

	public void run() {
		while(running) {
			double offsetVoltage = ai.getAverageVoltage() - offset;
			double rate = offsetVoltage - lastVoltage;
			if(rate < -2.0) {
				realRate = ANALOG_RANGE + rate;
				cycles++;
			} else if(rate > 2.0) {
				realRate = ANALOG_RANGE - rate;
				cycles--;
			} else {
				realRate = rate;
			}
			realDistance = ANALOG_RANGE * cycles + offsetVoltage;
			lastVoltage = offsetVoltage;
			Timer.delay(0.01);
		}
	}
	
	public double getDistance() {
		return (inverted ? -1.0 : 1.0) * realDistance;
	}
	
	public double getRate() {
		return (inverted ? -1.0 : 1.0) * realRate;
	}
	
	public void zero() {
		offset = ai.getAverageVoltage();
		realDistance = 0.0;
		realRate = 0.0;
		lastVoltage = 0.0;
		cycles = 0;
	}
	
	public void stop() {
		running = false;
	}
	
	public AnalogInput getAnalogInput() {
		return ai;
	}
	
	public boolean isInverted() {
		return inverted;
	}

	public void setInverted(boolean inverted) {
		this.inverted = inverted;
	}

	//Implemented methods from PIDSource so this class can easily operate as a PIDSource
	public void setPIDSourceType(PIDSourceType pidSource) {
		this.pidSource = pidSource;
	}

	public PIDSourceType getPIDSourceType() {
		return pidSource;
	}

	public double pidGet() {
		switch(pidSource) {
			case kRate:
				return getRate();
			case kDisplacement:
			default:
				return getDistance();
		}
	}

	@Override
	public void initTable(ITable subtable) {
		table = subtable;
		updateTable();
	}

	@Override
	public ITable getTable() {
		return table;
	}

	@Override
	public String getSmartDashboardType() {
		return "Encoder";
	}

	@Override
	public void updateTable() {
		if (table != null) {
			table.putNumber("Speed", getRate());
			table.putNumber("Distance", getDistance());
			table.putNumber("Distance per Tick", 0.0);
		}
	}

	@Override
	public void startLiveWindowMode() {}

	@Override
	public void stopLiveWindowMode() {}
}
