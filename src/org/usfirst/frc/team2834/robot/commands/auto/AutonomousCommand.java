package org.usfirst.frc.team2834.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This is a really big class so hold onto your ass.
 * 
 * It basically takes into account every situation we will be in for autonomous and
 * draws the best possible course for each one.
 * 
 */
public class AutonomousCommand extends CommandGroup {
    
    /**
     * @param mode What is the robot going to do?  Will it shoot?  will it cross a defense?  will it do jack shit?
     * @param position Mostly determines what rough angle to rotate before using vision tracking.
     * @param defense If and when the robot reaches a defense, which defense program should it use?
     * @param direction What direction is the robot facing?
     */
    public AutonomousCommand() {
    	//addSequential(new five_second());
    }
}

