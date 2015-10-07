package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team2415.robot.RobotMap;
/**
 *
 */
public class KidnapperSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Solenoid up, down;
	
	public boolean isDown;
	
	public KidnapperSubsystem(){
		up = new Solenoid(RobotMap.PCM, RobotMap.HOOK_UP);
		down = new Solenoid(RobotMap.PCM, RobotMap.HOOK_DOWN);
		up();
	}
	
	public void up(){
		down.set(false);
		up.set(true);
		isDown = false;
	}
	
	public void down(){
		down.set(true);
		up.set(false);
		isDown = true;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
}

