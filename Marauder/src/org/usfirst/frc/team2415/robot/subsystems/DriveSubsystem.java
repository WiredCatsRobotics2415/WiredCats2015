package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.PsuedoCrabDriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Transmission left, right, middle;
	
	//private Gyro gyro;

	public int maxVelocity;

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Transmission(RobotMap.LEFT_TALONS, RobotMap.LEFT_ENCODER);
		right = new Transmission(RobotMap.RIGHT_TALONS, RobotMap.RIGHT_ENCODER);
		middle = new Transmission(RobotMap.MIDDLE_TALONS, RobotMap.MIDDLE_ENCODER);
		
		//gyro = new Gyro(RobotMap.GYRO);
		
		//resetEncoders();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new PsuedoCrabDriveCommand());
    }
    
    public void setMotors(double left, double right, double middle){
    	this.left.set(left);
    	this.right.set(right);
    	this.middle.set(middle);
    }
    
    public void resetEncoders(){
    	left.resetEncoder();
    	right.resetEncoder();
    	middle.resetEncoder();
    }
    
    public float getRate(){
    	//returns a rate in feet per seconds
    	return (float)Math.max(left.getRate(), right.getRate());
    }
    
    public float getDistance(){
    	//returns distance traveled in feet
    	return (float)Math.max(left.getDistance(), right.getDistance());
    }
    /*
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }*/
    
}

