package org.usfirst.frc.team2415.robot.commands.elevator;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *	Raises the elevator to the desired hieght for the recycling bin.
 */
public class ElevateRecycleBinCommand extends Command {
	
	private float BIN_HEIGHT = 0;	//measured in inches
	
    public ElevateRecycleBinCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/* 
    	 * Robot.elevatorSubsystem.up();
    	 * 
    	 * */
    	Robot.elevatorSubsystem.up(Robot.tempStick.getY());
    	if(Robot.elevatorSubsystem.getEleHall()) Robot.elevatorSubsystem.resetEncoder();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//if(Robot.elevatorSubsystem.getHeight() >= BIN_HEIGHT) return true;
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.elevatorSubsystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	//SRobot.elevatorSubsystem.stop();
    }
}
