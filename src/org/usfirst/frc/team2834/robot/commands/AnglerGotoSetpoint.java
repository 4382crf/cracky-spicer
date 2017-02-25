package org.usfirst.frc.team2834.robot.commands;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command used to automatically position the angler to a specific encoder reading
 */
public class AnglerGotoSetpoint extends Command {
	
	private double setpoint;
	private double m_timeout = 3;

    public AnglerGotoSetpoint(double setpoint) {
        super("Angler goto Setpoint: [" + setpoint + "]");
        requires(Robot.angler);
        this.setpoint = setpoint;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.angler.reset();
    	Robot.angler.setpoint(0.0);
    	setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.angler.setpoint(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
    	return Robot.angler.setpoint(setpoint) || isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	Robot.angler.reset();
    	Robot.angler.setpoint(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
