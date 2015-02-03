package org.usfirst.frc.team2415.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleMakeItClapCommand extends Command {

    public ToggleMakeItClapCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//requires(Robot.bootySubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Object[] bootyStatus = Robot.bootySubsystem.getCheeks();
    	
    	//if(bootyStatus[0] == Robot.bootySubsystem.CLENCH){
    		//Robot.bootySubsystem.setCheeks(Robot.bootySubsystem.UNCLENCH, Robot.bootySubsystem.UNCLENCH);
    	//}else{
    		//Robot.bootySubsystem.setCheeks(Robot.bootySubsystem.CLENCH, Robot.bootySubsystem.CLENCH);
    	//}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
