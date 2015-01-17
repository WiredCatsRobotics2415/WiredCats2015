package org.usfirst.frc.team2415.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class ArcadeDriveCommand extends Command {

	private final float DEADBAND = 0;
	private final float SOME_VAR = 1;
	
    public ArcadeDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setLeftRight(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftStick = Robot.gamepad.leftY();
    	double rightStick = Robot.gamepad.rightX();
    	
    	if(Math.abs(leftStick) <= DEADBAND) leftStick = 0;
    	if(Math.abs(rightStick) <= DEADBAND) rightStick = 0;
    	
    	leftStick = Math.pow(leftStick, 3)*SOME_VAR + leftStick*(1-SOME_VAR);
    	rightStick = Math.pow(rightStick, 3)*SOME_VAR + rightStick*(1-SOME_VAR);
    	
    	double left = leftStick + rightStick;
    	double right = leftStick - rightStick;
    	
    	Robot.driveSubsystem.setLeftRight(left, right);
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
}
