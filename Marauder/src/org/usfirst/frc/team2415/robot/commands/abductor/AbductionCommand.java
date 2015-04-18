package org.usfirst.frc.team2415.robot.commands.abductor;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class AbductionCommand extends Command {
	
	long lastTime, currTime;
	float timePassed = 0;
	
	boolean hasFailed = false;
	
    public AbductionCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.kidnapperSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	lastTime = System.currentTimeMillis();
    	if(lastTime == 0){
    		System.out.println("Failed to set lastTime!");
    		hasFailed = true;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	currTime = System.currentTimeMillis();
    	timePassed += (currTime - lastTime) / 1000.0f;
    	
    	if(timePassed < 0.5){
    		Robot.kidnapperSubsystem.setMotors(-0.1);
    	}else if (timePassed < 1.0){
    		Robot.kidnapperSubsystem.setMotors(0.1);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (timePassed >= 1.0) || hasFailed; 
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kidnapperSubsystem.setMotors(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.kidnapperSubsystem.setMotors(0);
    }
}
