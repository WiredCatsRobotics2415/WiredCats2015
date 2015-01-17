package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.TankDriveCommand;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Talon left, right;
	
	public DriveSubsystem(){
		System.out.println("Drive Subsystem Created!");
		left = new Talon(RobotMap.TALON_LEFT);
		right = new Talon(RobotMap.TALON_RIGHT);
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
}

