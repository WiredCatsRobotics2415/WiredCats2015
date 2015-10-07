package org.usfirst.frc.team2415.robot.commands.abductor;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ToggleAbductorsCommand extends Command {

    public ToggleAbductorsCommand() {
        requires(Robot.kidnapperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.kidnapperSubsystem.isDown) Robot.kidnapperSubsystem.up();
    	else Robot.kidnapperSubsystem.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putBoolean("Am I Abducting?", Robot.kidnapperSubsystem.isDown);
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
