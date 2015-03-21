package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class HalfHeightCommand extends ElevatorMovementCommand {
	
    public HalfHeightCommand() {
    	super(Robot.elevatorSubsystem.HALF_HEIGHT);
    }
}
