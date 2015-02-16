package org.usfirst.frc.team2415.robot.subsystems;

import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.elevator.ElevateRecycleBinCommand;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DigitalInput;

/**
 *	Subsystem for all controllers and sensors used to control and monitor the elevator.
 */
public class ElevatorSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private final int TICKS_PER_INCH = 285;
			
	private Encoder encoder;
	
	private CANTalon talon1, talon2;
	
	private DigitalInput eleHall;
	
	private DoubleSolenoid toteNoid;
	
	private DoubleSolenoid elevatorBreak;
	
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
    
    /**Moves elevator up.*/
    public void up(double speed){
    	//elevatorBreak.set(DoubleSolenoid.Value.kReverse);
    	talon1.set(speed);
    	talon2.set(speed);
    }

    /**Move elevator down*/
    public void Down(){
    	elevatorBreak.set(DoubleSolenoid.Value.kReverse);
    	talon1.set(-1);
    	talon2.set(-1);
    }
    
    /**Returns count of the elevator hall effect sensor
     * @return <b>int</b> ticks counted each time the <br> elevator passes the height of the <br>
     * tote.*/
    public boolean getEleHall(){
    	return eleHall.get();
    }
    
    /**Resets the count of the elevator hall effect sensor.*/
    public void resetHall(){
    	//eleHall.reset();
    }
    
    /**Stops the movement of the elevator.*/
    public void stop(){
    	talon1.set(0);
    	talon2.set(0);
    	elevatorBreak.set(DoubleSolenoid.Value.kForward);
    }
    
    /**Activates the elevator's pushing solenoids to push the tote.*/
    public void pushTote(){
    	toteNoid.set(DoubleSolenoid.Value.kForward);
    }
    
    /**Retracts the elevator's pushing solenoids.*/
    public void retractToteNoid(){
    	toteNoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    /**Reset the tick count of the elevator encoder to 0.*/
    public void resetEncoder(){
    	encoder.reset();
    }
    
    /**Returns the current height of the elevator
     * 	@return <b>float</b> current height of the elevator in inches
     * */
    public float getHeight(){
    	return encoder.get();// * TICKS_PER_INCH;
    }
}

