package org.usfirst.frc.team2834.robot.commands.auto;

import org.usfirst.frc.team2834.robot.commands.GrabGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 */
public class AutonomousCommand extends CommandGroup {
    
    /**
     */
    public AutonomousCommand(int position, boolean side) {
    	if (position == 3){
    		//left
    		addSequential(new StopWhenFar(-0.7, 0, 65, 3));
        	addSequential(new RotateAngle(60, 0)); 
        	addSequential(new StopIfClose (-0.3, 0, 20, 3));
    	}
    	if (position == 2){ 
    		//middle
    		addSequential(new GrabGear(true));
    		addSequential(new StopWhenFar(-0.1, 0, 40, 3));
    		addSequential(new TimedHaloDrive(.5, 0 ,false, .1));
    		addSequential(new StopWhenFar(-0.05, 0, 25, 3));
    		addSequential(new TimedHaloDrive(.5, 0 ,false, .1));
    		addSequential(new GrabGear(false));
    		addSequential(new TimedHaloDrive(-.2, 0 ,false, 1));
    		
    	}
    	if (position == 1){
    		//right
    		//addSequential(new StopWhenFar(-0.7, 0, 65, 3));
        	addSequential(new RotateAngle(60, 0));
        	//addSequential(new StopIfClose (-0.3, 0, 20, 3));
    	}
    }
}