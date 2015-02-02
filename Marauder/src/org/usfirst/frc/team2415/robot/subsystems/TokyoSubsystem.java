package org.usfirst.frc.team2415.robot.subsystems;


import org.usfirst.frc.team2415.robot.commands.TokyoSubwayScrambleCommand;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;




public class TokyoSubsystem extends Subsystem {

	public void tokyoSubsytem(){
		
	}
	
	public void write(int registerAddress, int data) {
		
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TokyoSubwayScrambleCommand());
	}
	
}

