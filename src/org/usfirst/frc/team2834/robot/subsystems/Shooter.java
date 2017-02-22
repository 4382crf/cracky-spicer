package org.usfirst.frc.team2834.robot.subsystems;

import org.usfirst.frc.team2834.robot.RobotMap;

import com.DashboardSender;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Shooter extends Subsystem implements RobotMap, DashboardSender {
	
	
    // Initialize your subsystem here
	CANTalon _talon = new CANTalon(1);
	
    public Shooter() {
        super("Shooter");
        
        /* first choose the sensor */
        _talon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        _talon.reverseSensor(false);
        //_talon.configEncoderCodesPerRev(XXX), // if using FeedbackDevice.QuadEncoder
        //_talon.configPotentiometerTurns(XXX), // if using FeedbackDevice.AnalogEncoder or AnalogPot

        /* set the peak and nominal outputs, 12V means full */
        _talon.configNominalOutputVoltage(+0.0f, -0.0f);
        _talon.configPeakOutputVoltage(+12.0f, -12.0f);
        /* set closed loop gains in slot0 */
        _talon.setProfile(0);
        _talon.setF(0.1097);
        _talon.setP(0.22);
        _talon.setI(0); 
        _talon.setD(0);
        
        
    }
    
    public void setTalonSpeed(double power){
    	_talon.changeControlMode(TalonControlMode.Speed);
    	_talon.set(power);
    }
    
   
    
    @Override
	public void dashboardInit() {
        
    }
    
    @Override
	public void dashboardPeriodic() {
    	SmartDashboard.putNumber("Shooter Speed", _talon.get());

	}

	@Override
	public void initDefaultCommand() {
    }
}
