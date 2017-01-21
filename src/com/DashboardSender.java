package com;

import org.usfirst.frc.team2834.robot.Robot;

/**
 * @author Adam Raine
 *
 * This interface makes it easier on the programmer to send data to the dashboard.  It also
 * eliminates the error when SD values are initialized before the rest of the robot.
 * 
 * Any subsystem that needs to send specific data to the dashboard can implement
 * this interface.
 *
 */
public interface DashboardSender {
	
	DashboardSender[] senders = {
		Robot.drivetrain,
		Robot.oi
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
