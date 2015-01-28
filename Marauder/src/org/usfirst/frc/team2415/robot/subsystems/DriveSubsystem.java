package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.TankDriveCommand;
import org.usfirst.frc.team2415.robot.commands.ArcadeDriveCommand;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final float TICK_TO_FEET = 0;
	
	private Transmission left, right, middle;
	
	private CANTalon leftTalon, rightTalon;
	
	private Encoder leftEncoder, rightEncoder;

	public int maxVelocity;

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		leftTalon = new CANTalon(RobotMap.TALON_LEFT);
		rightTalon = new CANTalon(RobotMap.TALON_RIGHT);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		
		resetEncoders();
	}
	
	public DriveSubsystem(String driveType){
		System.out.println("Drive Subsystem Created!");
		left = new Transmission(RobotMap.TALON_LEFT_1, RobotMap.TALON_LEFT_2);
		right = new Transmission(RobotMap.TALON_RIGHT_1, RobotMap.TALON_RIGHT_2);
		middle = new Transmission(RobotMap.TALON_MIDDLE_1, RobotMap.TALON_MIDDLE_2);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		
		resetEncoders();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ArcadeDriveCommand());
    }
    
    public void setMotors(double left, double right){
    	leftTalon.set(left);
    	rightTalon.set(right);
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
    
}

