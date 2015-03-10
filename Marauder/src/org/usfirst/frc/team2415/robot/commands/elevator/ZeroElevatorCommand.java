package org.usfirst.frc.team2415.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2415.robot.Robot;

/**
 *
 */
public class ZeroElevatorCommand extends Command {
	
	private boolean relaxedState, excitedState;
	
	private boolean phase1 = true, zeroing = true;
	
	private double zeroHeight;
	
	private float glZone = .1f;
	
	private double moveSpeed = .5;
	
    public ZeroElevatorCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.elevatorSubsystem);
        System.out.println("CAUTION: Do not move/touch the robot! Currently Zeroing!");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	zeroHeight = Robot.elevatorSubsystem.getHeight() + 5;	//in inches
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(phase1){
    		double current = Robot.elevatorSubsystem.getHeight();
    		
    		if(Math.abs(current - zeroHeight) < glZone){
    			relaxedState = Robot.elevatorSubsystem.getHallEffect();
    			phase1 = false;
    			return;
    		}
    		
    		double output = Robot.elevatorSubsystem.basicPID.getPIDOutput(current, zeroHeight);
    		Robot.elevatorSubsystem.setMotors(output);
    	}else{
    		boolean hallEffectState = Robot.elevatorSubsystem.getHallEffect();
    		if(hallEffectState != relaxedState){
    			excitedState = hallEffectState;
    			Robot.elevatorSubsystem.resetEncoder();
    			zeroing = false;
    			return;
    		}
    		Robot.elevatorSubsystem.setMotors(moveSpeed);
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !zeroing;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevatorSubsystem.setHallEffectStates(excitedState, relaxedState);
    	Robot.elevatorSubsystem.setMotors(0);
    	System.out.println("Zeroing Finished!");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevatorSubsystem.setMotors(0);
    	System.out.println("WARNING: Zeroing Interrupted! Process was most likely not completed!");
    }
}
