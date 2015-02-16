package org.usfirst.frc.team2415.robot.commands.michaelJackson;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SnatchCommand extends Command {

    public SnatchCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.mjSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//TODO: Come back and determine the speed of the intake
    	Robot.mjSubsystem.snatch(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.mjSubsystem.snatch(1);
    	System.out.println(Robot.mjSubsystem.getLimitSwitch());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	System.out.println(Robot.mjSubsystem.getLimitSwitch());
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.mjSubsystem.snatch(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.mjSubsystem.snatch(0);
    }
}
