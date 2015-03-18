package org.usfirst.frc.team2415.robot.subsystems;

import com.kauailabs.nav6.frc.IMU;

import org.usfirst.frc.team2415.robot.MotionProfile;
import org.usfirst.frc.team2415.robot.PID;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.ArcadeDriveCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the drivetrain.
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final float INCHES_PER_TICK = 0.070093f;
	
	private final int BAUD_RATE = 57600;
	
	private final byte REFRESH_RATE = 50;
	
	private Talon left, right;
	
	private Encoder leftEncoder, rightEncoder;
	
	public MotionProfile motionprofile;
	public PID rotational_pid;
	
	private IMU imu;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.LEFT_TALON);
		right = new Talon(RobotMap.RIGHT_TALON);
		
		SerialPort imuSerialPort = new SerialPort(BAUD_RATE, SerialPort.Port.kMXP);
		imu = new IMU(imuSerialPort, REFRESH_RATE);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER[0], RobotMap.LEFT_ENCODER[1]);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER[0], RobotMap.RIGHT_ENCODER[1]);
		motionprofile = new MotionProfile(1.00f,5,1);
		rotational_pid = new PID(1.0f);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ArcadeDriveCommand());
    }
    /**Set the speed of each drive motor.
     * @param left speed value for the left motor between -1 and 1
     * @param right speed value for the right motor between -1 and 1*/
    public void setMotors(double left, double right){
    	this.left.set(left);
    	this.right.set(right);
    }
    
    public int getLeftEncoder(){
    	return leftEncoder.get();
    }
    
    public int getRightEncoder(){
    	return rightEncoder.get();
    }
    
    public void resetEncoder(){
    	leftEncoder.reset();
    	rightEncoder.reset();
    }
    
    public float getAngle(){
    	return imu.getYaw();
    }
    
    public void resetAngle(){
    	imu.zeroYaw();
    }
    
    public float getVelocity(){
    	return (float)leftEncoder.getRate()*INCHES_PER_TICK;
    }
    
    public boolean isGoingForward(){
    	return getVelocity() > 1.0f;
    }
    
    public boolean isGoingBackwards(){
//    	return
    }
    
    public float getDistance(){
    	int ticks = getLeftEncoder();
    	return INCHES_PER_TICK * ticks;
    }
    
    public float getYaw(){
    	return imu.getYaw();
    }
    
}

