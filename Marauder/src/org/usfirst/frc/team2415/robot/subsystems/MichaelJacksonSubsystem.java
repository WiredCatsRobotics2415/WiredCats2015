package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team2415.robot.Robot;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.ToggleClaspCommand;

/**
 *
 */
public class MichaelJacksonSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final Object EMBRACE = DoubleSolenoid.Value.kForward;
	public final Object RELEASE = DoubleSolenoid.Value.kReverse;
	
	private Talon leftHand, rightHand;
	private DoubleSolenoid leftArm, rightArm;
	
	public MichaelJacksonSubsystem(){
		leftHand = new Talon(RobotMap.MJ_TALONS[0]);
		rightHand = new Talon(RobotMap.MJ_TALONS[1]);
		
		release();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ToggleClaspCommand());
    }
    
    public void embrace(){
    	leftArm.set((DoubleSolenoid.Value)EMBRACE);
    	rightArm.set((DoubleSolenoid.Value)EMBRACE);
    }
    
    public void release(){
    	leftArm.set((DoubleSolenoid.Value)RELEASE);
    	rightArm.set((DoubleSolenoid.Value)RELEASE);
    }
    
    public void snatch(double speed){
    	leftHand.set(speed);
    	rightHand.set(-speed);
    }
    
    public Object[] getArms(){
    	Object[] arms = new Object[2];
    	arms[0] = leftArm.get();
    	arms[1] = rightArm.get();
    	
    	return arms;
    }
}

