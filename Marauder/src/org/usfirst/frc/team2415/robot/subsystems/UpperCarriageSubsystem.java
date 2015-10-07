package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.upperCarriage.TogglePokeCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;

/**
 *
 */
public class UpperCarriageSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Solenoid poke, unpoke;
	
	private boolean isPoking;
	
	public UpperCarriageSubsystem(){
		poke = new Solenoid(RobotMap.PCM, RobotMap.POKE);
		unpoke = new Solenoid(RobotMap.PCM, RobotMap.UNPOKE);
		
		unpoke();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    public void poke(){
    	poke.set(true);
    	unpoke.set(false);
    	isPoking = true;
    }
    
    public void unpoke(){
    	poke.set(false);
    	unpoke.set(true);
    	isPoking = false;
    }
    
    public boolean isPoking(){
    	return isPoking;
    }
}

