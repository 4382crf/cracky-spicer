
package org.usfirst.frc.team2834.robot;

import org.usfirst.frc.team2834.robot.commands.auto.AutonomousCommand;
import org.usfirst.frc.team2834.robot.subsystems.*;

import com.DashboardSender;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static OI oi;
    public static Drivetrain drivetrain;
    
    private CommandGroup auto;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public Robot() {
		drivetrain = new Drivetrain();
    }
    
    public void robotInit() {
    	oi = new OI();
    	DashboardSender.sendInitData();
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		DashboardSender.sendPeriodicData();
	}

	/**
	 * This function is called once before autonomous period starts
	 */
    public void autonomousInit() {
    	
    	auto = new AutonomousCommand();
		if (auto != null) auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        DashboardSender.sendPeriodicData();
    }

    public void teleopInit() {
    	//vision.useShooterView();
    	//new FreeShooter().start();
        if (auto != null) auto.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        DashboardSender.sendPeriodicData();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
