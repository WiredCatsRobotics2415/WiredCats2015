package org.usfirst.frc.team2415.robot;

public class PID {
	
	private double currDesired = 0;
	private double prevDesired;
	
	private float kP, kI, kD;
	
	public PID(float p){
		kP = p;
	}
	
	private double potential(double current, double desired){
		return kP*(desired-current);
	}
	
	public double getDesired(){
		return currDesired;
	}
	
	public double pidOutput(double current, double desired){
		prevDesired = currDesired;
		currDesired = desired;
		return potential(current, desired);
	}
}
