package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import org.usfirst.frc.team2415.robot.RobotMap;
import org.usfirst.frc.team2415.robot.commands.booty.ToggleMakeItClapCommand;


/**
 *	Subsystem for all controllers and sensors used to control and monitor the Booty Subsystem<br>
 *	(aka the clapper).
 *	<b>*Not to be used until further notice*</b>
 */
public class BootySubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	/**Solenoid state of activation for the "cheeks" of the booty subsystem.*/
	public final Object CLENCH = DoubleSolenoid.Value.kForward;
	
	/**Solenoid state of deactivation for the "cheeks" of the booty subsystem.*/
	public final Object UNCLENCH = DoubleSolenoid.Value.kReverse;
	
	private DoubleSolenoid leftCheek;
	private DoubleSolenoid rightCheek;
	
	public BootySubsystem(){
		leftCheek = new DoubleSolenoid(RobotMap.LEFT_CHEEK[0], RobotMap.LEFT_CHEEK[1]);
		rightCheek = new DoubleSolenoid(RobotMap.RIGHT_CHEEK[0], RobotMap.RIGHT_CHEEK[1]);
	}
	
	/**Returns an Object array of length 2 containing the two cheek.
	 * @return <b>Object[]</b> objects that represents the state of the two cheeks<br>
	 * of the booty subsystem (of the two arms of the clapper). Each */
	public Object[] getCheeks(){
		Object[] cheeks = new Object[2];
		cheeks[0] = leftCheek.get();
		cheeks[1] = rightCheek.get();
		
		return cheeks;
		
	}
	
	/**Activates the pistons(cheeks) of the booty subsystem.*/
	public void clench(){
		leftCheek.set((DoubleSolenoid.Value)CLENCH);
		rightCheek.set((DoubleSolenoid.Value)CLENCH);
	}
	
	/**Deactivates the pistons(cheeks) of the booty subsystem.*/
	public void unclench(){
		leftCheek.set((DoubleSolenoid.Value)UNCLENCH);
		rightCheek.set((DoubleSolenoid.Value)UNCLENCH);	
	}
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ToggleMakeItClapCommand());
    }
}

