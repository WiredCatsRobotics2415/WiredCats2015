package org.usfirst.frc.team2415.robot;

public class PID {
	
	private double desired = 0;
	
	private float kP, kI, kD;
	
	public PID(float p){
		kP = p;
	}
	
	private double potential(double current, double desired){
		double error = desired-current;
		if (error > 180) error = 180;
		if (error < -180) error = -180;
		return kP*error;
	}
	
	public double getDesired(){
		return desired;
	}
	
	public double pidOutput(double current, double desired){
		this.desired = desired;
		return potential(current, desired);
	}
}
