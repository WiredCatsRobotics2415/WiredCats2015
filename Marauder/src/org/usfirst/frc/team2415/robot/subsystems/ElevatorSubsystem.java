package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.elevator.ElevateRecycleBinCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import org.usfirst.frc.team2415.robot.PID;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the elevator.
 */
public class ElevatorSubsystem extends Subsystem {
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    /*
    public PID basicPID = new PID(.25f);
    */
    
    //private final int TICKS_PER_INCH = 285;
    private final float TICKS_PER_INCH = 1/63.9f;
    
    private float lastPos;
    private long lastTume;
	
    private Encoder encoder;
    
    private CANTalon talon1, talon2;
	
    private DigitalInput eleHall;
	
    public ElevatorSubsystem(){
	talon1 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[0]);
	talon2 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[1]);
	
	encoder = new Encoder(RobotMap.ELEVATOR_ENCODER[0], RobotMap.ELEVATOR_ENCODER[1]);
	
	eleHall = new DigitalInput(RobotMap.EVELATOR_HALL_EFFECT);
	
	//elevatorBreak = new DoubleSolenoid(RobotMap.ELEVATOR_BREAK_SOLENOID[0], RobotMap.ELEVATOR_BREAK_SOLENOID[1]);
	//toteNoid = new DoubleSolenoid(RobotMap.ELEVATOR_PUSH_SOLENOID[0], RobotMap.ELEVATOR_PUSH_SOLENOID[1]);}
    }
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    	setDefaultCommand(new ElevateRecycleBinCommand());
    }
    
    public void setMotors(double speed){
    	talon1.set(speed);
    	talon2.set(speed);
    }
    
    public double getPIDOut(double desired){
    	return 0;
    }
    
    public boolean getEleHall(){
    	return !eleHall.get();
    }
    
    public int getHeight(){
    	return encoder.get() * TICKS_PER_INCH;
    }
    
    public float getVelocity(){
    	float currPos = getHeight();
    	long currTime = System.currentTimeMillis();
    	
    	float distance = currPos - lastPos;
    	float time = (currTime - lastIme) / 1000.0f
    	
    	lastPos = currPos;
    	lastTime = currTime;
    	
    	return distance / time;
    }
}

