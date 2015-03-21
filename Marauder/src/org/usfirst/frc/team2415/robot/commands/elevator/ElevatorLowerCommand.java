package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class ElevatorLowerCommand extends ElevatorMovementCommand {
	
    public ElevatorLowerCommand() {
    	super(Robot.elevatorSubsystem.LOWER_HEIGHT);
    }
}
