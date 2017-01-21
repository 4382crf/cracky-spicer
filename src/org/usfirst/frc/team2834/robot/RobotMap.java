package org.usfirst.frc.team2834.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public interface RobotMap {
    //Joystick USB number
	int RIGHT_DRIVE_USB = 0;
	int LEFT_DRIVE_USB = 1;
	int OPERATOR_USB = 2;
	
	//Drivetrain motor PWM ports
	int FRONT_LEFT_DRIVETRAIN = 0;
	int FRONT_RIGHT_DRIVETRAIN = 1;
	int MIDDLE_LEFT_DRIVETRAIN = 2;
	int MIDDLE_RIGHT_DRIVETRAIN = 3;
	int BACK_LEFT_DRIVETRAIN = 4;
	int BACK_RIGHT_DRIVETRAIN = 5;
}
 