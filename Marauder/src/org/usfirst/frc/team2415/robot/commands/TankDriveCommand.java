package org.usfirst.frc.team2415.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class TankDriveCommand extends Command {
	
	private final float DEADBAND = 0;
	private final float SOME_VAR = 1;
	
    public TankDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setMotors(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftVal = Robot.gamepad.leftY();
    	double rightVal = Robot.gamepad.rightY();
    	
    	if(Math.abs(leftVal) <= DEADBAND) leftVal = 0;
    	if(Math.abs(rightVal) <= DEADBAND) rightVal = 0;
    	
    	leftVal = Math.pow(leftVal, 3)*SOME_VAR + leftVal*(1-SOME_VAR);
    	rightVal = Math.pow(rightVal, 3)*SOME_VAR + rightVal*(1-SOME_VAR);
    	
    	Robot.driveSubsystem.setMotors(leftVal, rightVal);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.setMotors(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.setMotors(0, 0);
    }
}
