package org.usfirst.frc.team2834.robot;

import org.usfirst.frc.team2834.robot.commands.*;
import org.usfirst.frc.team2834.robot.commands.auto.TimedAngle;

import com.DashboardSender;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI implements RobotMap, DashboardSender {
	
	//Joysticks, two for driving, one for other functions
	public final Joystick rightDrive;
	public final Joystick leftDrive;
	public final Joystick operator;
	
	//Buttons
	public final JoystickButton Setpoint;
	public final JoystickButton Hanger;
	public final JoystickButton Agitate;
	public final JoystickButton Grab;
	public final JoystickButton Release;
	public final JoystickButton Intake;
	public final JoystickButton GearDown;
	public final JoystickButton GearUp;
	public final JoystickButton FastHang;
	public final JoystickButton Reverse;
	public final JoystickButton reverseAgitate;
	
	public OI() {
		//Initialize joysticks
		rightDrive = new Joystick(RobotMap.RIGHT_DRIVE_USB);
		leftDrive = new Joystick(RobotMap.LEFT_DRIVE_USB);
		operator = new Joystick(RobotMap.OPERATOR_USB);
		
		//Initialize buttons
		Setpoint = new JoystickButton(rightDrive, SETPOINT_BUTTON);
		Hanger = new JoystickButton(operator, HANG_BUTTON);
		Agitate = new JoystickButton(rightDrive, AGITATOR_BUTTON);
		reverseAgitate = new JoystickButton(rightDrive, REVERSE_AGITATOR_BUTTON);
		Grab = new JoystickButton(operator, GRAB_BUTTON);
		Release = new JoystickButton(operator, RELEASE_BUTTON);
		Intake = new JoystickButton(operator, INTAKE_BUTTON);
		GearDown = new JoystickButton(operator, GEARDOWN_BUTTON);
		GearUp = new JoystickButton(operator, GEARUP_BUTTON);
		FastHang = new JoystickButton(operator, FASTHANG_BUTTON);
		Reverse = new JoystickButton(operator, REVERSE);
		
		
		//Set button functions
		Setpoint.toggleWhenPressed(new ShooterSetSetpoint(1000));
		Hanger.whileHeld(new Hang());
		Agitate.whileHeld(new Agitate(-0.8));
		Intake.toggleWhenPressed(new IntakeBall());
		Grab.whenPressed(new GrabGear(true));
		Release.whenPressed(new GrabGear(false));
		GearUp.whenPressed(new TimedAngle(-0.3, 2));
		GearDown.whenPressed(new TimedAngle(0.3, 2));
		GearDown.whenPressed(new GrabGear(false));
		FastHang.whileHeld(new FastHang());
		Reverse.whileHeld(new Reverse());
		reverseAgitate.whileHeld(new Agitate(0.8));
	}

	@Override
	public void dashboardInit() {
		SmartDashboard.putData(Scheduler.getInstance());
	}

	@Override
	public void dashboardPeriodic() {
	}
}

