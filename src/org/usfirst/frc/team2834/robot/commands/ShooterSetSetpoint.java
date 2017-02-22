package org.usfirst.frc.team2834.robot.commands;

import org.usfirst.frc.team2834.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Sets the speed of the shooter wheels to specific encoder values.
 */
public class ShooterSetSetpoint extends Command {
	

	double setpoint = (double) SmartDashboard.getNumber("Shooter Speed", 0);
    
    public ShooterSetSetpoint(double setpoint) {
    	super("Shooter Set Setpoint: [" + setpoint + "]");
    	requires(Robot.shooter);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.shooter.setTalonSpeed(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
