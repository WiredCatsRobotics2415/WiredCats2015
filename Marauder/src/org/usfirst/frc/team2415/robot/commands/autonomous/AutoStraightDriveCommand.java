package org.usfirst.frc.team2415.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;

public class AutoStraightDriveCommand extends Command {
	
	private float destination;
	private float currentPosition;
	
	private float currentVelocity;
	private float desiredVelocity;
	
    public AutoStraightDriveCommand(float destination) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	this.destination = destination;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setLeftRight(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPosition = Robot.driveSubsystem.getDistance();
    	
    	currentVelocity = Robot.driveSubsystem.getRate();
    	desiredVelocity = getDesiredVelocity();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.setLeftRight(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.setLeftRight(0, 0);
    }
    
    public float getDesiredVelocity(){
    	return 0;
    }
}
