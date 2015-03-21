package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class ElevatorLiftCommand extends ElevatorMovementCommand {
	
    public ElevatorLiftCommand() {
    	super(Robot.elevatorSubsystem.LIFT_HEIGHT);
    }
}
