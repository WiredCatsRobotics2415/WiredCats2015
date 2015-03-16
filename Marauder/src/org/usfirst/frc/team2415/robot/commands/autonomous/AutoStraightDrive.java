package org.usfirst.frc.team2415.robot.commands.autonomous;

import org.usfirst.frc.team2415.robot.MotionProfile;
import org.usfirst.frc.team2415.robot.PID;
import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoStraightDrive extends Command {

	private float desired_distance;
	private MotionProfile motionprofile;
	private PID rotational_pid;
	
    public AutoStraightDrive(float distance_in_inches) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.driveSubsystem);
        this.desired_distance = distance_in_inches;
        this.motionprofile = Robot.driveSubsystem.motionprofile;
    	motionprofile.setDesired(distance_in_inches, 0);
    	this.rotational_pid = Robot.driveSubsystem.rotational_pid;
    	this.setTimeout(4);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.resetEncoder();
    	Robot.driveSubsystem.resetAngle();
    	System.out.println("initialized straight drive");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	float currVel = Robot.driveSubsystem.getVelocity();
    	double power = motionprofile.power(Robot.driveSubsystem.getDistance(), currVel);
//    	double _____s = rotational_pid.getPIDOutput(Robot.driveSubsystem.getAngle(), 0);
    	double _____s = rotational_pid.getPIDOutput(Robot.driveSubsystem.getDistance(),this.desired_distance);
    	double rot = rotational_pid.getPIDOutput(Robot.driveSubsystem.getYaw(), 0);
    	if (_____s > .90) _____s = .90;
    	if (_____s < -.90) _____s = -.90;
    	double leftPower = _____s - rot;
    	double rightPower = _____s + rot;
    	Robot.driveSubsystem.setMotors(-leftPower, rightPower); //TODO actually make sure if it's supposed to be backwards 	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(Robot.driveSubsystem.getDistance()) > Math.abs(.95*desired_distance) || isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("successfully drove the whole way");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
