
package org.usfirst.frc.team2834.robot;

import org.usfirst.frc.team2834.robot.commands.auto.AutonomousCommand;
import org.usfirst.frc.team2834.robot.subsystems.*;

import com.DashboardSender;

import edu.wpi.first.wpilibj.CameraServer;
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
    public static Distance distance;
    public static Shooter shooter;
    public static Angler angler;
    public static Hanger hanger;
    public static Agitator agitator;
    public static GearGrab geargrab;
    public static Intake intake;
    public static FakeShoot fakeshoot;
    
    private CommandGroup auto;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    public Robot() {
		drivetrain = new Drivetrain();
		distance = new Distance();
		shooter = new Shooter();
		angler = new Angler(); 
		hanger = new Hanger();
		agitator = new Agitator();
		geargrab = new GearGrab();
		intake = new Intake();
		fakeshoot = new FakeShoot();
    }
    
    public void setAnglePower(double power){
    	angler.setPower(power);
    }
    
    @Override
	public void robotInit() {
    	oi = new OI();
    	DashboardSender.sendInitData();
    	CameraServer.getInstance().startAutomaticCapture();
    	
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    @Override
	public void disabledInit(){
    }
	
	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		DashboardSender.sendPeriodicData();
	}

	/**
	 * This function is called once before autonomous period starts
	 */
    @Override
	public void autonomousInit() {
    	
    	int position = (int) SmartDashboard.getNumber("Position", 0);
    	//true = Blue
    	boolean side = SmartDashboard.getBoolean("Side", false);
    	
    	auto = new AutonomousCommand(position, side);
    	
		if (auto != null) auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
	public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        DashboardSender.sendPeriodicData();
    }

    @Override
	public void teleopInit() {
    	//vision.useShooterView();
    	//new FreeShooter().start();
        if (auto != null) auto.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
	public void teleopPeriodic() {
        Scheduler.getInstance().run();
        DashboardSender.sendPeriodicData();
    }
    
    /**
     * This function is called periodically during test mode
     */
    @Override
	public void testPeriodic() {
        LiveWindow.run();
    }
}
