package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.booty.ToggleMakeItClapCommand;


/**
 *
 */
public class BootySubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public final Object CLENCH = DoubleSolenoid.Value.kForward;
	public final Object UNCLENCH = DoubleSolenoid.Value.kReverse;
	
	private DoubleSolenoid leftCheek;
	private DoubleSolenoid rightCheek;
	
	public BootySubsystem(){
		leftCheek = new DoubleSolenoid(RobotMap.LEFT_CHEEK[0], RobotMap.LEFT_CHEEK[1]);
		rightCheek = new DoubleSolenoid(RobotMap.RIGHT_CHEEK[0], RobotMap.RIGHT_CHEEK[1]);
	}
	
	
	public Object[] getCheeks(){
		Object[] cheeks = new Object[2];
		cheeks[0] = leftCheek.get();
		cheeks[1] = rightCheek.get();
		
		return cheeks;
		
	}
	
	public void clench(){
		leftCheek.set((DoubleSolenoid.Value)CLENCH);
		rightCheek.set((DoubleSolenoid.Value)CLENCH);
	}
	
	public void unclench(){
		leftCheek.set((DoubleSolenoid.Value)UNCLENCH);
		rightCheek.set((DoubleSolenoid.Value)UNCLENCH);	
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ToggleMakeItClapCommand());
    }
}

