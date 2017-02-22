package org.usfirst.frc.team2834.robot.subsystems;

import org.usfirst.frc.team2834.robot.RobotMap;

import com.DashboardSender;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 */
public class GearGrab extends Subsystem implements RobotMap, DashboardSender {
    
    Servo gear;
    public static final double CLOSE = 1;
    public static final double OPEN = 0.0;

    public GearGrab() {
    	super("Gear");
    	gear = new Servo(GEAR_GRABBER);
    	setPusherPosition(OPEN);
    }
    
    public void setPusherPosition(double pos) {
    	gear.set(pos);
    }
    
    public boolean getPosition(double position){
    	boolean pos = true;
    	if (position > 0){
    		pos = false;
    	}
    	if (position < 0.2){
    		pos = true;
    	}
    	return pos;
    }
    
    @Override
	public void initDefaultCommand() {
    }

	@Override
	public void dashboardInit() {
	}

	@Override
	public void dashboardPeriodic() {
		SmartDashboard.putBoolean("Gear Holder", getPosition(gear.get()));
	}
}

