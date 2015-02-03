package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.IntakeCommand;

/**
 *
 */
public class IntakeSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Talon leftIntake, rightIntake;
	
	public IntakeSubsystem(){
		leftIntake = new Talon(RobotMap.INTAKE_TALONS[0]);
		rightIntake = new Talon(RobotMap.INTAKE_TALONS[1]);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new IntakeCommand());
    }
}

