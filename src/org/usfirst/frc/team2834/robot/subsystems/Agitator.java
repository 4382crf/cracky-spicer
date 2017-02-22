package org.usfirst.frc.team2834.robot.subsystems;

import org.usfirst.frc.team2834.robot.RobotMap;

import com.DashboardSender;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Agitator extends Subsystem implements RobotMap, DashboardSender {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private Victor Motor= new Victor(AGITATOR_MOTOR);
	
	 public void agitate(double power) {
	    	Motor.set(power);
	    }
	 public double agitatorPower(){
		 double power = Motor.get();
		 return power;
	 }

    @Override
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

	@Override
	public void dashboardInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dashboardPeriodic() {
		// TODO Auto-generated method stub
		SmartDashboard.putNumber("Agitator Power", agitatorPower());
	}
}

