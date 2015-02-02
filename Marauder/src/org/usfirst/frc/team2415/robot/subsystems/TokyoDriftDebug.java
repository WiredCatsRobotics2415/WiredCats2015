package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.commands.Nitro;
import org.usfirst.frc.team2415.robot.commands.ToggleMakeItClapCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;




public class TokyoDriftDebug extends Subsystem {

	public void TokyoDriftDebug(){
		int data = 1;
		int registerAddress = 4;
		I2C i2c = new I2C(I2C.Port.kOnboard, 168);	
	}

	 public void write(int registerAddress, int data) {
		
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new Nitro());
		
	}
	
	
}

