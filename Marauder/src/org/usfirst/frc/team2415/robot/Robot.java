
package org.usfirst.frc.team2415.robot;

import org.usfirst.frc.team2415.robot.commands.elevator.ZeroElevatorCommand;
import org.usfirst.frc.team2415.robot.commands.elevator.*;
import org.usfirst.frc.team2415.robot.commands.michaelJackson.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team2415.robot.subsystems.*;

import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static OI oi;
	
	public static DriveSubsystem driveSubsystem;
	public static MichaelJacksonSubsystem mjSubsystem;
	public static TokyoSubsystem tokyoSubsystem;
	public static ElevatorSubsystem elevatorSubsystem;
	
	private Command zeroElevatorCommand;
	
	private Compressor compressor;
	
	public static GamePad gamepad;
	
	public static Joystick tempStick;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		
		compressor = new Compressor();	//enter compressor port if need be
		/*compressor should run automatically (according the api) until specifically told to stop
		 *It runs on its own separate loop (doesn't specify if that loop is on a different thread
		 *but there little doubt because of the limitation in hardware - two weak CPU cores)
		 */
		
		driveSubsystem = new DriveSubsystem();
		//bootySubsystem = new BootySubsystem();
		mjSubsystem = new MichaelJacksonSubsystem();
		//tokyoSubsystem = new TokyoSubsystem();
		elevatorSubsystem = new ElevatorSubsystem();
		
		tempStick = new Joystick(1);
		
		gamepad = new GamePad(0);
		
		//gamepad.a_button.whenPressed(new ElevatorLiftCommand());
		//gamepad.b_button.whenPressed(new ElevatorLowerCommand());
		gamepad.leftTrigger.whileHeld(new ClaspCommand());
		gamepad.rightTrigger.whileHeld(new FreeCommand());
		gamepad.rightBumper.whileHeld(new SnatchCommand());
		
        // instantiate the command used for the autonomous period
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        //if (autonomousCommand != null) autonomousCommand.cancel();
		//zeroElevatorCommand = new ZeroElevatorCommand();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        System.out.println(Robot.elevatorSubsystem.getHallEffect());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
