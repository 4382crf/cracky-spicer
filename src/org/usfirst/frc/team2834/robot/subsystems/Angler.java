package org.usfirst.frc.team2834.robot.subsystems;

import org.usfirst.frc.team2834.robot.RobotMap;

import com.DashboardSender;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 */
public class Angler extends PIDSubsystem implements RobotMap, DashboardSender {
    
	private Victor anglerMotor;
	private Encoder anglerEncoder;
	
	public Angler() {
		super("Angler", 0.004, 0.0000025, 0.0);
		anglerMotor = new Victor(ANGLER_MOTOR);
		anglerEncoder = new Encoder(ANGLER_ENCODER_A, ANGLER_ENCODER_B);
		//Initialize PID values for the angle of the Grabber
        setOutputRange(-0.5, 0.5);
        getPIDController().setAbsoluteTolerance(1);
	}
	
    @Override
	public void initDefaultCommand() {
        //Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double setPower(double power){
    	anglerMotor.set(power);
    	return power;
    }
    
    public boolean setpoint(double setpointValue){
    	double currentValue = anglerEncoder.get();
    	boolean done = false;
    	while (currentValue != setpointValue){
    		if (setpointValue >= currentValue){
    			anglerMotor.set(0.2);
    		}
    		if (setpointValue <= currentValue){
    			anglerMotor.set(-0.2);
    		}
    		if (setpointValue == currentValue){
    			anglerMotor.set(0);
    			done = true;
    		}
    	}
    	return done;
    	
    }
    
    boolean currentPosition = false;
    
    public boolean anglePosition(double power){
    	if (power < 0){
    		currentPosition = true;
    	}
    	if (power > 0){
    		currentPosition = false;
    	}
    	
    	return currentPosition;
    }
    
    public boolean timeout(int milliseconds){
    	boolean isFinished = false;
    	try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	isFinished = true;
    	return isFinished;
    }
    
    public int getEncoderCount(){
    	int encoderCount = anglerEncoder.get();
		return encoderCount;
    	
    }
    
    public void reset() {
    	anglerEncoder.reset();
    }
    
	@Override
	protected double returnPIDInput() {
		return anglerEncoder.getDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		anglerMotor.set(-output);
	}
	
	@Override
	public void dashboardInit() {
		//SmartDashboard.putNumber("Gear Angle", getEncoderCount());
	}

	@Override
	public void dashboardPeriodic() {
		SmartDashboard.putNumber("Gear Angle", getEncoderCount());
		SmartDashboard.putBoolean("Gear Position", anglePosition(anglerMotor.get()));
	}
}

