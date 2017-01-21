package org.usfirst.frc.team2834.robot.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class five_second extends CommandGroup {

    public five_second() {
    	super("Five Second Drive");
        addSequential(new TimedHaloDrive(1, 0, false, 5));
    }
}
