package org.usfirst.frc.team2834.robot.commands.auto;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Rotates a certain degree relative to the current robot position
 */
public class RotateAngle extends Command {
	
	private double angle;
	private double forwardPower;

    public RotateAngle(double angle, double forwardPower) {
    	super("Rotate Angle: [" + angle + "] [" + forwardPower + "]", 10);
        requires(Robot.drivetrain);
        this.angle = angle;
        this.forwardPower = forwardPower;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.drivetrain.rezero();
    	Robot.drivetrain.reset();
    	Robot.drivetrain.setZero();
    	Robot.drivetrain.setSetpoint(Robot.drivetrain.getYaw());
    	Robot.drivetrain.setSetpointRelative(angle);
    	Robot.drivetrain.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.drivetrain.haloDrive(-forwardPower, 0.0, true);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return Robot.drivetrain.onTarget() || isTimedOut();
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	Robot.drivetrain.disable();
    	Robot.drivetrain.setZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
