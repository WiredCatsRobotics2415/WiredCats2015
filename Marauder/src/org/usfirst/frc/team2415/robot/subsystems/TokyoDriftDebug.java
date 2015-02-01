package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.commands.Nitro;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;

  

public class TokyoDriftDebug extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	//Commit N
	public TokyoDriftDebug(){
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new Nitro());
    }
}

