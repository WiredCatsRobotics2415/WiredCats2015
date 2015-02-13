package org.usfirst.frc.team2415.robot.commands.tokyoLighting;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;

public class TokyoSubwayScrambleCommand extends Command {
	int registerAddress = 4;
	int data;
	
	@Override
	protected void initialize() {
		
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
