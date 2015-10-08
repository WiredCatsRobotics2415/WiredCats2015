package org.usfirst.frc.team2415.robot.commands.abductor;

import edu.wpi.first.wpilibj.command.Command;
import static org.usfirst.frc.team2415.robot.Robot.*;;
/**
 *
 */
public class ToggleKidnapCommand extends Command {

    public ToggleKidnapCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(kidnapperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(kidnapperSubsystem.isDown()) kidnapperSubsystem.up();
    	else kidnapperSubsystem.down();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
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
