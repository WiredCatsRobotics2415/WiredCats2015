package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class ElevatorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private Encoder encoder1, encoder2;
	
	private CANTalon talon1, talon2;
	
	private DoubleSolenoid elevatorBreak;

	public ElevatorSubsystem(){
		talon1 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[0]);
		talon2 = new CANTalon(RobotMap.ELEVATOR_CAN_TALONS[1]);
		
		encoder1 = new Encoder(RobotMap.ELEVATOR_ENCODER_1[0], RobotMap.ELEVATOR_ENCODER_1[1]);
		encoder2 = new Encoder(RobotMap.ELEVATOR_ENCODER_2[0], RobotMap.ELEVATOR_ENCODER_2[1]);
		
		elevatorBreak = new DoubleSolenoid(RobotMap.ELEVATOR_BREAK_SOLENOID[0], RobotMap.ELEVATOR_BREAK_SOLENOID[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
    }
    
    //moves elevator up to elevation required to stack tote
    public void upTote(){}

    //moves elevator up to elevation required to stack recycling bin
    public void upRecycleBin(){
    	talon1.set(1);
    	talon2.set(1);
    }

    //moves elevator down from tote elevation
    public void downFromTote(){}

    //moves elevator down from recycling bin elevation
    public void downFromRecycleBin(){}
}

