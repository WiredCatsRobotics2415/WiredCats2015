package org.usfirst.frc.team2415.robot;

public class MotionProfile {
	
	private PID pid;
	private float maxVel;
	private float desired;
	private float totalDistance;
	private float error;
	private float dv_over_dx;
	
	private final float MINIMUM_VELOCITY;
	
	/**
	 * simplified constructor
	 * @param p
	 * @param maxVel
	 * @param dv_over_dx
	 */
	public MotionProfile(float vel_k_p, float maxVel, float dv_over_dx){
		this(vel_k_p, maxVel, dv_over_dx, .1f);
	}
	
	/**
	 * 
	 * @param p
	 * @param maxVel
	 * @param dv_over_dx the rate at which velocity increases in terms of x;
	 * not quite acceleration, a slightly different derivative.
	 */
	public MotionProfile(float vel_k_p, float maxVel, float dv_over_dx, float MINIMUM_VELOCITY){
		pid = new PID(vel_k_p);
		this.dv_over_dx = dv_over_dx;
		this.MINIMUM_VELOCITY = MINIMUM_VELOCITY;
		setDesired(0,0);
	}
	
	public void setDesired(float desired, float start){
		this.desired = desired;
		totalDistance = desired-start;
	}
	
	/**
	 * takes the trapezoidal profile and determines the alloted power necessary via
	 * pid control over velocity.
	 * @param current
	 * @return
	 */
	public float power(float currPos, float currVel){
		float power = 0, desVel = 0;
		error = desired-currPos;
		
		//first part of trapezoid; the line that goes up
		if (error < .5*totalDistance){
			desVel = dv_over_dx*error + MINIMUM_VELOCITY;
		} else {
			desVel = dv_over_dx*(totalDistance - error);
		}
		
		//now that we've determined the correct velocity 
		//let's convert that to power
		
		power = (float) pid.getPIDOutput(currVel, desVel);
		
		//set velocity cap. This changes the graphs
		//shape from triangle to trapezoid.
		if (Math.abs(power) > maxVel){
			if (power < 0) power = -maxVel;
			else power = maxVel;
		}
		return power;
	}
}
