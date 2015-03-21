package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorMovementCommand extends Command {

	private float desiredHeight;
	
    public ElevatorMovementCommand(float desiredHeight) {
        // Use requires() here to declare subsystem dependencies
    	//if(Robot.operator.buttons[1].get()) end();
    	
        requires(Robot.elevatorSubsystem);
        this.desiredHeight = desiredHeight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevatorSubsystem.setCurrentDesired(desiredHeight);
    	double current = Robot.elevatorSubsystem.getHeight();
    	double output = Robot.elevatorSubsystem.basicPID.getPIDOutput(current, Robot.elevatorSubsystem.getCurrentDesired());
    	Robot.elevatorSubsystem.setMotors(output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
