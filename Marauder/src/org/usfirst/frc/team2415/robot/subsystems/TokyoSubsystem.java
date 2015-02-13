package org.usfirst.frc.team2415.robot.subsystems;


import org.usfirst.frc.team2415.robot.commands.tokyoLighting.TokyoSubwayScrambleCommand;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;




public class TokyoSubsystem extends Subsystem {
	private I2C i2c;
	
	public void tokyoSubsytem(){
		i2c = new I2C(I2C.Port.kOnboard, 0);
	}
	
	public void write(int registerAddress, int data) {
		i2c.write(registerAddress, data);
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new TokyoSubwayScrambleCommand());
	}
	
}

