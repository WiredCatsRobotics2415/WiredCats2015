package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PsuedoCrabDriveCommand extends Command {
	
	private final float DEADBAND = 0;
	private final float INTERPOLATION_FACTOR = 0;
	
	private long lastTime, now;

    public PsuedoCrabDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	lastTime = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setMotors(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	now = System.currentTimeMillis();
    	long time = (now - lastTime)/1000;
    	lastTime = now;
    	
    	double leftY = Robot.gamepad.leftY();
    	double rightX = Robot.gamepad.rightX();
    	
    	double turnSpeed = rightX*Robot.driveSubsystem.maxTurnRate;
    	double addAngle = turnSpeed*time;
    	double newDesiredAngle = addAngle + Robot.driveSubsystem.pid.getDesired();
    	double angularVelocity = Robot.driveSubsystem.pid.pidOutput(
    			Robot.driveSubsystem.getAngle(), newDesiredAngle);
    	
    	double left = leftY*(Math.abs(leftY) - Math.abs(angularVelocity/2)) + angularVelocity/2;
    	double right = leftY*(Math.abs(leftY) - Math.abs(angularVelocity/2)) - angularVelocity/2;
    	
    	Robot.driveSubsystem.setMotors(left, right);
    	
    	System.out.println("Current Angle, current rate: " + Robot.driveSubsystem.getAngle() + ", " + 
    														 Robot.driveSubsystem.getRate());
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
