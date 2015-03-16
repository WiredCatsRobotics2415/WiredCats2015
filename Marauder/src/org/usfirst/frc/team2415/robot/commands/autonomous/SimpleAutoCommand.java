package org.usfirst.frc.team2415.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;
/**
 *
 */
public class SimpleAutoCommand extends Command {
	
	private float travelTime;
	
	private float time;
	private float lastTime;
	private boolean finished;
	
    public SimpleAutoCommand(float travelTime) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        this.setTimeout(travelTime);
        time = 0;
        finished = false;
        lastTime = System.currentTimeMillis();
        this.travelTime=travelTime;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	float currentTime = System.currentTimeMillis();
    	time += (currentTime - lastTime) / 1000.0f;
    	lastTime = currentTime;
    	
    	if(time >= travelTime){
    		finished = true;
    		return;
    	}
    	
    	Robot.driveSubsystem.setMotors(0.5, -0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finished || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
