package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.TankDriveCommand;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final float TICK_TO_FEET = 0;
	
	private Talon left, right;
	
	private Encoder leftEncoder, rightEncoder;

	public int maxVelocity;

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.TALON_LEFT);
		right = new Talon(RobotMap.TALON_RIGHT);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		
		resetEncoders();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDriveCommand());
    }
    
    public void setLeftRight(double left, double right){
    	this.left.set(left);
    	this.right.set(right);
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

