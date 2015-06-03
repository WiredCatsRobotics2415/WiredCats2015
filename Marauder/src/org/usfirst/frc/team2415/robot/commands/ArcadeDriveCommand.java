package org.usfirst.frc.team2415.robot.commands;

import org.usfirst.frc.team2415.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ArcadeDriveCommand extends Command {
	
	private final float DEADBAND = 0;
	private final float INTERPOLATION_FACTOR = .6f;
	
	private final float ACCEL_CONSTANT = 0.75f; 
	
	private double currentSpeed = 0;
	private final float DIFF_CONTROL = 0.05f;
	private final float ACCEL_ADD = 0.01f;
	
	long lastTime = 0;

    public ArcadeDriveCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSubsystem.setMotors(0, 0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putNumber("LeftVelocity", Robot.driveSubsystem.getLeftVelocity());
    	SmartDashboard.putNumber("RightVelocity", Robot.driveSubsystem.getRightVelocity());
    	
    	if (lastTime == 0) lastTime = System.currentTimeMillis();
    	
    	long currTime = System.currentTimeMillis();
    	float timePassed = (currTime - lastTime) / 1000.0f;
    	
    	double leftY = Robot.gamepad.leftY();
    	double rightX = Robot.gamepad.rightX();
    	
    	if(Math.abs(leftY) < DEADBAND) leftY = 0;
    	if(Math.abs(rightX) < DEADBAND) rightX = 0;
    	
    	leftY = INTERPOLATION_FACTOR*Math.pow(leftY, 3) + (1 - INTERPOLATION_FACTOR)*leftY;
    	rightX = INTERPOLATION_FACTOR*Math.pow(rightX, 3) + (1 - INTERPOLATION_FACTOR)*rightX;

    	
    	//WARNING INCOMING BEN & OMARI CODE THIS JUST MIGHT MAKE THE ROBOT EXPLODE
    	
    	
    	double diffSpeed = Math.abs(leftY - currentSpeed);
    	if (diffSpeed > DIFF_CONTROL){
    		double addSpeed = timePassed*Math.copySign(ACCEL_ADD, -currentSpeed);
    		leftY += addSpeed;
    	}
    	
    	currentSpeed = leftY;
    	lastTime = currTime;
    	
    	double left = leftY - rightX;
    	double right = leftY + rightX;
    	
    	/* Coasting Version 1
    	if ((Robot.driveSubsystem.getVelocity() > 0.1 && leftY > 0) ||
    			(Robot.driveSubsystem.getVelocity() < -0.1 && leftY < 0)){
    		left *= ACCEL_CONSTANT;
    		right *= ACCEL_CONSTANT;
    		System.out.println("Coasting");
    	}
    	*/
    	
    	Robot.driveSubsystem.setMotors(left, -right);
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
