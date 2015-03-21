package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ElevatorManualCommand extends Command {

	private double desired;
	private final float MAX_CHANGE_RATE = 3;	//inches per second
	
	long lastTime, currentTime;
	
    public ElevatorManualCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
        lastTime = System.currentTimeMillis();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	desired = Robot.elevatorSubsystem.getCurrentDesired();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currentTime = System.currentTimeMillis();
    	float timePassed = (currentTime - lastTime) / 1000.0f;
    	lastTime = currentTime;
    	
    	double joyVal = -1*Robot.operator.getY();
    	if(Math.abs(joyVal) < .1) joyVal = 0;
    	
    	desired += timePassed*MAX_CHANGE_RATE*joyVal;
    	
    	System.out.println(joyVal + ", " + desired);
    	
    	double current = Robot.elevatorSubsystem.getHeight();
    	double output = Robot.elevatorSubsystem.basicPID.getPIDOutput(current, desired);
    	Robot.elevatorSubsystem.setMotors(output);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return !Robot.operator.buttons[1].get();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.setCurrentDesired(desired);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevatorSubsystem.setCurrentDesired(desired);
    }
}
