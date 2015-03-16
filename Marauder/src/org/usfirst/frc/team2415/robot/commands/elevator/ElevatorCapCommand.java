package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorCapCommand extends Command {

    public ElevatorCapCommand() {
        requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double current = Robot.elevatorSubsystem.getHeight();
    	double output = Robot.elevatorSubsystem.basicPID.getPIDOutput(current, Robot.elevatorSubsystem.getCapHeight());
    	System.out.println(output + "," + current);
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
