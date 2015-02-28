package org.usfirst.frc.team2415.robot;

public class PID {
	private float kP, kI, kD;
	
	public PID(float p,float i, float d){
		kP = p;
		kI = i;
		kD = d;
	}
	
	public PID(float p,float i){
		this(p, i, 0);
	}
	
	public PID(float p){
		this(p, 0);
	}
	
	private double proportional(double desired, double current){
		return ((desired-current)/desired)*kP;
	}
	
	public double getPIDOutPut(double desired, double current){
		return proportional(desired, current);
	}
}
