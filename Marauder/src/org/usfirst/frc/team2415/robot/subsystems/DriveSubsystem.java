package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.PsuedoCrabDriveCommand;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final float TICK_TO_FEET = 0;
	
	private Transmission left, right, middle;
	
	private Gyro gyro;
	
	private Encoder leftEncoder, rightEncoder;

	public int maxVelocity;

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Transmission(RobotMap.TALON_LEFT_1, RobotMap.TALON_LEFT_2);
		right = new Transmission(RobotMap.TALON_RIGHT_1, RobotMap.TALON_RIGHT_2);
		middle = new Transmission(RobotMap.TALON_MIDDLE_1, RobotMap.TALON_MIDDLE_2);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		
		gyro = new Gyro(RobotMap.GYRO);
		
		resetEncoders();
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
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public float getRate(){
    	//returns a rate in feet per seconds
    	return TICK_TO_FEET*(float)Math.max(leftEncoder.getRate(), rightEncoder.getRate());
    }
    
    public float getDistance(){
    	//returns distance traveled in feet
    	return TICK_TO_FEET*(float)Math.max(Math.abs(leftEncoder.getRaw()), Math.abs(rightEncoder.getRate()));
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
}

