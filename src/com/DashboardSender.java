package com;

import org.usfirst.frc.team2834.robot.Robot;

/**
 */
public interface DashboardSender {
	
	DashboardSender[] senders = {
		Robot.drivetrain,
		Robot.oi,
		Robot.distance,
		Robot.angler,
		Robot.agitator,
		Robot.fakeshoot,
		Robot.shooter,
		Robot.geargrab
	};
	
	static void sendPeriodicData() {
		try {
			for(DashboardSender s : senders) {
				s.dashboardPeriodic();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	static void sendInitData() {
		try {
			for(DashboardSender s : senders) {
				s.dashboardInit();
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	void dashboardInit();
	void dashboardPeriodic();
}
