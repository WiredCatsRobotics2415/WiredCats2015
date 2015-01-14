package org.usfirst.frc.team2415.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2415.robot.OI;
import org.usfirst.frc.team2415.robot.GamePad;
import org.usfirst.frc.team2415.robot.subsystems.*;

/**
 *
 */
abstract public class CommandBase extends Command {
	
	public static OI oi;
	public static DriveSubsystem driveSubsystem = new DriveSubsystem();
	
	public static GamePad gamepad = new GamePad(1);
	
	public static void init(){
		oi = new OI();
	}
	
    public CommandBase(String name) {
    	super(name);
    }
    
    public CommandBase(){
    	super();
    }
}
