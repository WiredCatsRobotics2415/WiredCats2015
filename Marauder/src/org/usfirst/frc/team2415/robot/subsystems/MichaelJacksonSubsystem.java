package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.michaelJackson.ToggleClaspCommand;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the Michael Jackson system<br>
 *	(aka the intake system).
 */
public class MichaelJacksonSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/**Solenoid state of activation for the arms of the Michael Jackson system.*/
	public final Object EMBRACE = DoubleSolenoid.Value.kForward;
	
	/**Solenoid state of deactivation for the arms of the Michael Jackson system.*/
	public final Object RELEASE = DoubleSolenoid.Value.kReverse;
	
	private Talon leftHand, rightHand;
	private DoubleSolenoid leftArm, rightArm;
	
	private DigitalInput limitSwitch;
	
	public MichaelJacksonSubsystem(){
		leftHand = new Talon(RobotMap.MJ_TALONS[0]);
		rightHand = new Talon(RobotMap.MJ_TALONS[1]);
		
		limitSwitch = new DigitalInput(RobotMap.LIMIT_SWITCH);
		
		//release();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new ToggleClaspCommand());
    }
    
    /**Activate the pistons of the intake system to clamp the arms onto */
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
    
    public boolean getLimitSwitch(){
    	return limitSwitch.get();
    }
}

