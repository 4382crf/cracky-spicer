package org.usfirst.frc.team2834.robot.commands;

import org.usfirst.frc.team2834.robot.Robot;
import org.usfirst.frc.team2834.robot.subsystems.GearGrab;

import edu.wpi.first.wpilibj.command.Command;

/**
 */
public class GrabGear extends Command {

	private double position;
	
    public GrabGear(boolean out) {
    	super("Pusher Out: [" + out + "]");
        requires(Robot.geargrab);
        position = out ? GearGrab.OPEN : GearGrab.CLOSE;
    }

    // Called just before this Command runs the first time
    @Override
	protected void initialize() {
    	Robot.geargrab.setPusherPosition(position);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
	protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
	protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    @Override
	protected void end() {
    	//Robot.pusher.setPusherPosition(Pusher.OFF);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
	protected void interrupted() {
    	end();
    }
}
