package org.usfirst.frc.team2415.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;

public class AutoStraightDriveCommand extends Command {
	
	private float destination;
	private float currentPosition;
	
	private float currentVelocity;
	private float desiredVelocity;
	
	private double velPower;
	private double strPower;
	
	private boolean forwards;
	
    public AutoStraightDriveCommand(float destination, boolean forwards) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    	this.destination = destination;
    	this.forwards = forwards;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentPosition = 0;
    	currentVelocity = 0;
    	desiredVelocity = 0;
    	velPower = 0;
    	strPower = 0;
    	
    	Robot.driveSubsystem.setMotors(0, 0);
    }
    


    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentPosition = Robot.driveSubsystem.getDistance();
    	
    	currentVelocity = Robot.driveSubsystem.getRate();
    	desiredVelocity = getDesiredVelocity(currentPosition);
    	
    	double left, right;
    	
    	if(forwards){
    		left = velPower + strPower;
    		right =  velPower - strPower;
    	}else{
    		left = velPower - strPower;
    		right =  velPower + strPower;
    	}
    	
    	Robot.driveSubsystem.setMotors(left, right);
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
    
    public float getDesiredVelocity(float position){
	    if (position < 1f){
	        return (float)((Robot.driveSubsystem.maxVelocity-Robot.driveSubsystem.motor_dead_band))*position+Robot.driveSubsystem.motor_dead_band;
	    } else if ( position > destination - Robot.driveSubsystem.decceleration_dist){
	        float m = -Robot.driveSubsystem.maxVelocity/Robot.driveSubsystem.decceleration_dist;
	        return m * (position - (destination - Robot.driveSubsystem.decceleration_dist)) + Robot.driveSubsystem.maxVelocity;
	    } else {
	        return Robot.driveSubsystem.maxVelocity;
	    }
    }
}
