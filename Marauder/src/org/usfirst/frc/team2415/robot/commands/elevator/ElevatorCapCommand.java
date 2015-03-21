package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class ElevatorCapCommand extends ElevatorMovementCommand {
	
    public ElevatorCapCommand() {
    	super(Robot.elevatorSubsystem.CAP_HEIGHT);
    }
}
