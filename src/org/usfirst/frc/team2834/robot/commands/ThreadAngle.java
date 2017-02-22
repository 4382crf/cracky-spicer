package org.usfirst.frc.team2834.robot.commands;

import org.usfirst.frc.team2834.robot.Robot;

public class ThreadAngle extends Thread {
	public Robot robot = null;
	public double seconds;
	public double power;

	public ThreadAngle(Robot robot, double seconds, double power) {
		super();
		this.robot = robot;
		this.seconds = seconds;
		this.power = power;
	}
	
	public void run(double seconds, double power){
		seconds = 2;
		robot.setAnglePower(power);
		int time = (int) seconds * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		robot.setAnglePower(0.0);
	}
}
