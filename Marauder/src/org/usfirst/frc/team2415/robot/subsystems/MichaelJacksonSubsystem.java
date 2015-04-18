package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;


import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.michaelJackson.DefaultMJCommand;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the Michael Jackson system<br>
 *	(aka the intake system).
 */
public class MichaelJacksonSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Talon leftHand, rightHand;
	
	private DigitalInput proximity;
	
	private double snatchSpeed = .75;
	
	public MichaelJacksonSubsystem(){
		leftHand = new Talon(RobotMap.MJ_TALONS[0]);
		rightHand = new Talon(RobotMap.MJ_TALONS[1]);
		
		proximity = new DigitalInput(RobotMap.PROXIMITY);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultMJCommand());
    }
    
    public boolean getProximity(){
    	return proximity.get();
    }
    
    public void snatch(){
    	if(proximity.get()){
    		leftHand.set(snatchSpeed*.75);
    		rightHand.set(-snatchSpeed*.75);
    		return;
    	}
    	leftHand.set(snatchSpeed);
    	rightHand.set(-snatchSpeed);
    }
    
    public void free(){
    	leftHand.set(-snatchSpeed);
    	rightHand.set(snatchSpeed);
    }
    
    public void stop(){
    	leftHand.set(0);
    	rightHand.set(0);
    }
    
}

