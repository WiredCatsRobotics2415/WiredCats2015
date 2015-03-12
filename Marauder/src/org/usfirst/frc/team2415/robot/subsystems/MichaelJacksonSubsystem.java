package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Solenoid;

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
	private Solenoid clasp, unclasp;
	
	private double snatchSpeed = 1;
	
	public MichaelJacksonSubsystem(){
		leftHand = new Talon(RobotMap.MJ_TALONS[0]);
		rightHand = new Talon(RobotMap.MJ_TALONS[1]);
		
		clasp = new Solenoid(RobotMap.CLASP_SOLENOID);
		unclasp = new Solenoid(RobotMap.UNCLASP_SOLENOID);
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new DefaultMJCommand());
    }
    
    /**Activate the pistons of the intake system to clamp the arms onto */
    public void clasp(){
    	clasp.set(true);
    	unclasp.set(false);
    }
    
    public void unclasp(){
    	clasp.set(false);
    	unclasp.set(true);
    }
    
    public void snatch(){
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

