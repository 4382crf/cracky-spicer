package org.usfirst.frc.team2834.robot.subsystems;

import com.DashboardSender;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */


public class Distance extends Subsystem implements DashboardSender {

	AnalogInput rangeFront = new AnalogInput(0);
	AnalogInput rangeBack = new AnalogInput(1);
	double voltage;


	@Override
	public void initDefaultCommand() {
    	
    }
    public double getDistance(int unit, int side){
    	//0 = Front 
    	//1 = Back
    	if (side == 0){
        	voltage = rangeFront.getVoltage();
    	}
    	if (side == 1){
        	voltage = rangeBack.getVoltage();
    	}
    	double inches = voltage/0.009766;
    	double distance;
    	if (unit == 1){
    		//millimeters
    		distance = inches*25.4;
    	}
    	if (unit == 2){
    		//centimeters
    		distance = inches*2.54;
    	}
    	else{
    		//inches
    		distance = inches;
    	}
    	return distance;
    }
    public boolean isClose(double distance, int unit) {
		return getDistance(unit, 1) <= distance;
	}
    
    public boolean isFar(double distance, int unit) {
		return getDistance(unit, 0) >= distance;
	}
	@Override
	public void dashboardInit() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void dashboardPeriodic() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Inches Front", getDistance(3, 0));
		SmartDashboard.putNumber("Inches Back", getDistance(3, 1));
	}
}
