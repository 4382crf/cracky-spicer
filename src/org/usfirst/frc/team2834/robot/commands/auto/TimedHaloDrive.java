package org.usfirst.frc.team2834.robot.commands.auto;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Basic command to run the Drivetrain for a period of time in Halo Drive.
 */
public class TimedHaloDrive extends Command {
	
	private double power;
	private double rotate;
	private boolean holdRotation;
	
    public TimedHaloDrive(double power, double rotate, boolean holdRotation, double seconds) {
    	super("Timed Halo Drive: [" + power + "] [" + rotate + "] [" + holdRotation + "] [" + seconds + "]", seconds);
        requires(Robot.drivetrain);
        this.power = power;
        this.rotate = rotate;
        this.holdRotation = holdRotation;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(holdRotation) {
    		Robot.drivetrain.setSetpoint(Robot.drivetrain.getYaw());
    	}
    	Robot.drivetrain.setZero();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.haloDrive(-power, rotate, holdRotation);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.disable();
    	Robot.drivetrain.setZero();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
