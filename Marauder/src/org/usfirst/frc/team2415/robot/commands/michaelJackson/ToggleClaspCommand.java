package org.usfirst.frc.team2415.robot.commands.michaelJackson;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleClaspCommand extends Command {

    public ToggleClaspCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.mjSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.mjSubsystem.getArms()[0] == Robot.mjSubsystem.RELEASE) Robot.mjSubsystem.embrace();
    	else Robot.mjSubsystem.release();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
