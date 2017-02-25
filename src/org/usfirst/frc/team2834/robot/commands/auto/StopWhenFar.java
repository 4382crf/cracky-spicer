package org.usfirst.frc.team2834.robot.commands.auto;

import org.usfirst.frc.team2834.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class StopWhenFar extends Command {
	
	private double power;
	private double rotate;
	private double distance;
	private int unit;
	private int side;
	
    public StopWhenFar(double power, double rotate, double distance, int unit, int side) {
    	super("Stop when far: [" + power + "] [" + rotate);
        requires(Robot.drivetrain);
        this.power = power;
        this.rotate = rotate;
        this.distance = distance;
        this.unit = unit;
        this.side = side;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    	Robot.drivetrain.haloDrive(power, rotate, false);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
    	return Robot.distance.isFar(distance, unit, side);
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	Robot.drivetrain.haloDrive(0, 0.0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
