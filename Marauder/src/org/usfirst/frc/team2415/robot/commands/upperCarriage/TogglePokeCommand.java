package org.usfirst.frc.team2415.robot.commands.upperCarriage;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 *
 */
public class TogglePokeCommand extends Command {

    public TogglePokeCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.upperCarriageSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(Robot.upperCarriageSubsystem.isPoking()) Robot.upperCarriageSubsystem.unpoke();
    	else Robot.upperCarriageSubsystem.poke();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    // needs review -->	SmartDashboard.putBoolean( "isItPoking?", isPoking());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
