package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.MotionProfile;
import org.usfirst.frc.team2415.robot.PID;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.elevator.DefaultElevatorCommand;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the elevator.
 */
public class ElevatorSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public PID basicPID = new PID(.25f);
	
    MotionProfile basicProfile = new MotionProfile(.25f, 1f, .01f);
    
    //private final int INCH_PER_TICKS = 285;	//for the competition bot
    private final float INCH_PER_TICKS = 1/63.9f;	//for the practice bot
    
    private float lastPos;
    private long lastTime;
    
    private int liftHeight = 16, lowerHeight = 7;
    
    private int currentDesiredHeight;
    
    public boolean isLifting = false;
	
    private boolean excitedState, relaxedState;
    
    private Encoder encoder;
    
    private CANTalon talon1, talon2;
	
    private DigitalInput hallEffect;
	
    public ElevatorSubsystem(){
		talon1 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[0]);
		talon2 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[1]);
		
		encoder = new Encoder(RobotMap.ELEVATOR_ENCODER[0], RobotMap.ELEVATOR_ENCODER[1]);
		
		hallEffect = new DigitalInput(RobotMap.EVELATOR_HALL_EFFECT);

    	lastTime = System.currentTimeMillis();
    	lastPos = getHeight();
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new DefaultElevatorCommand());
    }
    
    public void setMotors(double speed){
    	talon1.set(speed);
    	talon2.set(speed);
    }
    
    public boolean getHallEffect(){
    	return !hallEffect.get();
    }
    
    public float getHeight(){
    	return encoder.get() * INCH_PER_TICKS;
    }
    
    /*getVelocity version 1
    public float getVelocity(){
    	float currPos = getHeight();
    	long currTime = System.currentTimeMillis();
    	
    	float distance = currPos - lastPos;
    	float time = (currTime - lastTime) / 1000.0f;
    	
    	lastPos = currPos;
    	lastTime = currTime;
    	
    	return distance / time;
    }*/
    
    //getVelocity version 2
    public float getVelocity(){
    	return (float)encoder.getRate() * INCH_PER_TICKS;
    }
    
    public void resetEncoder(){
    	encoder.reset();
    }
    
    public void setHallEffectStates(boolean excitedState, boolean relaxedState){
    	this.excitedState = excitedState;
    	this.relaxedState = relaxedState;
    }
    
    public boolean getExcitedState(){
    	return excitedState;
    }
    
    public boolean getRelaxedState(){
    	return relaxedState;
    }
    
    
    public int getLiftHeight(){
    	return liftHeight;
    }
    
    public int getLowerHeight(){
    	return lowerHeight;
    }
}

