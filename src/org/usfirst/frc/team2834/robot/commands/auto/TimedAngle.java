package org.usfirst.frc.team2834.robot.commands.auto;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command used to automatically position the angler to a specific encoder reading
 */
public class TimedAngle extends Command {
	
	private double power;
	private double m_timeout;

    public TimedAngle(double power, double timeout) {
        super("Angler goto Setpoint: [" + power + "]");
        requires(Robot.angler);
        this.power = power;
        m_timeout = timeout;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.angler.reset();
    	setTimeout(m_timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.angler.setPower(power);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
    	return isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	Robot.angler.reset();
    	Robot.angler.setPower(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
