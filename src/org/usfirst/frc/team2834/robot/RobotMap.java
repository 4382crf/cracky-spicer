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
	
	//Joystick Drive Buttons
	int AGITATOR_BUTTON = 1;
	int SETPOINT_BUTTON = 3;
	int REVERSE_AGITATOR_BUTTON =4;
	
	//Joystick Operator Buttons
	int HANG_BUTTON = 2;
	int FASTHANG_BUTTON = 1;
	int GRAB_BUTTON = 4;
	int RELEASE_BUTTON = 3;
	int INTAKE_BUTTON = 7;
	int REVERSE = 8;
	int GEARDOWN_BUTTON = 5;
	int GEARUP_BUTTON = 6;
	
	
	
	//Drivetrain motor PWM ports
	int FRONT_LEFT_DRIVETRAIN = 0;
	int FRONT_RIGHT_DRIVETRAIN = 1;
	int MIDDLE_LEFT_DRIVETRAIN = 2;
	int MIDDLE_RIGHT_DRIVETRAIN = 3;
	int BACK_LEFT_DRIVETRAIN = 4;
	int BACK_RIGHT_DRIVETRAIN = 5;
	
	//Shooter Ports
	int SHOOTER_MOTOR = 13;
	int SHOOTER_ENCODER_A = 2;
	int SHOOTER_ENCODER_B = 3;
	int FAKESHOOT = 9;
	
	//Gear system ports
	int GEAR_GRABBER = 11;
	int ANGLER_MOTOR = 7;
	int ANGLER_ENCODER_A = 0;
	int ANGLER_ENCODER_B = 1;
	
	//Agitator
	int AGITATOR_MOTOR = 10;
	
	//Hanger
	int HANGER_MOTOR = 6;
	
	//intake
	int INTAKE_MOTOR = 8;
}
 