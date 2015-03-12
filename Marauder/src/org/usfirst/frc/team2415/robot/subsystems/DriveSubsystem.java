package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.ArcadeDriveCommand;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the drivetrain.
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Talon left, right;
	
	private Encoder leftEncoder, rightEncoder;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.LEFT_TALON);
		right = new Talon(RobotMap.RIGHT_TALON);
		
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER[0], RobotMap.LEFT_ENCODER[1]);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER[0], RobotMap.RIGHT_ENCODER[1]);
		
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
    
}

