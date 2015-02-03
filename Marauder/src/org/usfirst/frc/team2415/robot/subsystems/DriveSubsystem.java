package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.PID;
import org.usfirst.frc.team2415.robot.commands.PsuedoCrabDriveCommand;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public PID pid = new PID(1/180);
	
	private final double GYRO_SENSITIVITY = .007;
	
	private Talon left, right, middle;
	
	private Encoder leftEncoder, rightEncoder, middleEncoder;
	
	private Gyro gyro;

	public int maxVelocity;
	
	public float maxTurnRate = 180;	//in degrees per second

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.LEFT_TALON);
		right = new Talon(RobotMap.RIGHT_TALON);
		middle = new Talon(RobotMap.MIDDLE_TALON);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER[0], RobotMap.LEFT_ENCODER[1]);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER[0], RobotMap.RIGHT_ENCODER[1]);
		middleEncoder = new Encoder(RobotMap.MIDDLE_ENCODER[0], RobotMap.MIDDLE_ENCODER[1]);
		
		gyro = new Gyro(RobotMap.GYRO);
		gyro.setSensitivity(GYRO_SENSITIVITY);	//in measurement of Volts/degree/second
		
		resetGyro();
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
    	middleEncoder.reset();
    }
    /*
    public float getRate(){
    	//returns a rate in feet per seconds
    	return (float)Math.max(left.getRate(), right.getRate());
    }
    
    public float getDistance(){
    	//returns distance traveled in feet
    	return (float)Math.max(left.getDistance(), right.getDistance());
    }
    */
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
}

