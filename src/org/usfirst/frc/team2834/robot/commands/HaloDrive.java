package org.usfirst.frc.team2834.robot.commands;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic driving method for two joysticks
 */
public class HaloDrive extends Command {
	
    public HaloDrive() {
    	super("Halo Drive");
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.drivetrain.setZero();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.drivetrain.haloDrive(-Robot.oi.leftDrive.getY(), -Robot.oi.rightDrive.getX(), false);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	Robot.drivetrain.setZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
