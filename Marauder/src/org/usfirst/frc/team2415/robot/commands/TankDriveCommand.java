package org.usfirst.frc.team2415.robot.commands;

/**
 *
 */
public class TankDriveCommand extends CommandBase {

    public TankDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	requires(driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveSubsystem.setLeftRight(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	driveSubsystem.setLeftRight(gamepad.leftY(), gamepad.rightY());
    	System.out.println("Ayyy boi");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveSubsystem.setLeftRight(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	driveSubsystem.setLeftRight(0, 0);
    }
}
