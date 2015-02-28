package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevateToteCommand extends Command {
	
    private final float TOTE_HEIGHT = 0;
	
    public ElevateToteCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = Robot.elevatorSubsystem.getPidOut(TOTE_HEIGHT);
    	Robot.elevatorSubsystem.setMotors(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.elevatorSubsystem.getHeight() >= TOTE_HEIGHT) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevatorSubsystem.stop();
    }
}
