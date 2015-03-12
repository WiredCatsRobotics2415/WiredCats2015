package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorLiftCommand extends Command {
	
    public ElevatorLiftCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorSubsystem.setMotors(0);
    	Robot.elevatorSubsystem.isLifting = !Robot.elevatorSubsystem.isLifting;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double current = Robot.elevatorSubsystem.getHeight();
    	double output = Robot.elevatorSubsystem.basicPID.getPIDOutput(current, Robot.elevatorSubsystem.getLiftHeight());
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
