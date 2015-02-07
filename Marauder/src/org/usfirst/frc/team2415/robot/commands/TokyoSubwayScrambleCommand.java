package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

public class TokyoSubwayScrambleCommand extends Command {
	
	I2C i2c;
	int registerAddress = 4;
	int data;
	
	@Override
	protected void initialize() {
		I2C i2c = new I2C(I2C.Port.kOnboard, 0);
		
	}

	@Override
	protected void execute() {
		Robot.tokyoSubsystem.write(registerAddress, data);

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub

	}

}
