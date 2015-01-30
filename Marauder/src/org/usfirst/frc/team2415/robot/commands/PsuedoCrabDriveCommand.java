package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PsuedoCrabDriveCommand extends Command {
	
	private final float DEADBAND = 0;
	private final float INTERPOLATION_FACTOR = 1;

    public PsuedoCrabDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftX = Robot.gamepad.leftX();
    	double leftY = Robot.gamepad.leftY();

    	double rightX = Robot.gamepad.leftX();
    	
    	if(Math.abs(leftY) < DEADBAND) leftY = 0;
    	if(Math.abs(leftX) < DEADBAND) leftX = 0;
    	if(Math.abs(rightX) < DEADBAND) rightX = 0;
    	
    	leftX = Math.pow(leftX, 3)*INTERPOLATION_FACTOR + leftX*(1-INTERPOLATION_FACTOR);
    	leftY = Math.pow(leftY, 3)*INTERPOLATION_FACTOR + leftY*(1-INTERPOLATION_FACTOR);
    	rightX = Math.pow(rightX, 3)*INTERPOLATION_FACTOR + rightX*(1-INTERPOLATION_FACTOR);
    	
    	double left = leftY + rightX;
    	double right = leftY - rightX;
    	double middle = leftX;
    	
    	Robot.driveSubsystem.setMotors(-left, right, middle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveSubsystem.setMotors(0, 0, 0);
    }
}
