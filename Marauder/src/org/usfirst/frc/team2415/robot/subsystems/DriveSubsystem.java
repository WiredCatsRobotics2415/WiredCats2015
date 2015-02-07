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
	
	private Talon left, right;
	
	private Gyro gyro;

	public int maxVelocity;
	
	public float maxTurnRate = 180;	//in degrees per second

	public float decceleration_dist;

	public int motor_dead_band;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.LEFT_TALON);
		right = new Talon(RobotMap.RIGHT_TALON);
		
		gyro = new Gyro(RobotMap.GYRO);
		gyro.setSensitivity(GYRO_SENSITIVITY);	//in measurement of Volts/degree/second
		
		resetGyro();
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new PsuedoCrabDriveCommand());
    }
    
    public void setMotors(double left, double right){
    	this.left.set(left);
    	this.right.set(right);
    }
    
    public double getAngle(){
    	return gyro.getAngle();
    }
    
    public double getRate(){
    	return gyro.getRate();
    }
    
    public void resetGyro(){
    	gyro.reset();
    }
    
}

