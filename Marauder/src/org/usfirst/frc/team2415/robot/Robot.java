
package org.usfirst.frc.team2415.robot;

import org.usfirst.frc.team2415.robot.commands.elevator.*;
import org.usfirst.frc.team2415.robot.commands.abductor.*;
import org.usfirst.frc.team2415.robot.commands.michaelJackson.*;
import org.usfirst.frc.team2415.robot.commands.upperCarriage.*;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc.team2415.robot.subsystems.*;

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
	public static ElevatorSubsystem elevatorSubsystem;
	public static UpperCarriageSubsystem upperCarriageSubsystem;
	public static KidnapperSubsystem kidnapperSubsystem;
	
	private Compressor compressor;
	public static Joystick tempStick;
	
	public static GamePad gamepad;
	
	public static WiredCatJoystick operator;
	
	Preferences prefs;
	public static double speedModifier;
	public static float inchesPerTick;
	
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		prefs = Preferences.getInstance();
		
		compressor = new Compressor(RobotMap.PCM);	//enter compressor port if need be
		/*compressor should run automatically (according the api) until specifically told to stop
		 *It runs on its own separate loop (doesn't specify if that loop is on a different thread
		 *but there little doubt because of the limitation in hardware - two weak CPU cores)
		 */
		
		driveSubsystem = new DriveSubsystem();
		mjSubsystem = new MichaelJacksonSubsystem();
		elevatorSubsystem = new ElevatorSubsystem();
		upperCarriageSubsystem = new UpperCarriageSubsystem();
		kidnapperSubsystem = new KidnapperSubsystem();
		
		gamepad = new GamePad(0);
		operator = new WiredCatJoystick(1);
		//tempStick = new Joystick(0);
		
		operator.buttons[6].whenPressed(new ElevatorMovementCommand(elevatorSubsystem.LIFT_HEIGHT));
		gamepad.x_button.whenPressed(new ElevatorMovementCommand(elevatorSubsystem.LIFT_HEIGHT));
		operator.buttons[7].whenPressed(new ElevatorMovementCommand(elevatorSubsystem.LOWER_HEIGHT));
		gamepad.y_button.whenPressed(new ElevatorMovementCommand(elevatorSubsystem.LOWER_HEIGHT));
		operator.buttons[8].whenPressed(new ElevatorMovementCommand(elevatorSubsystem.HALF_HEIGHT));
		gamepad.a_button.whenPressed(new ElevatorMovementCommand(elevatorSubsystem.HALF_HEIGHT));
		//operator.buttons[9].whenPressed(new ElevatorMovementCommand(elevatorSubsystem.CAP_HEIGHT));
		
		operator.buttons[5].whenPressed(new TogglePokeCommand());
		
		operator.buttons[11].whileHeld(new ZeroingCommand());
		operator.buttons[4].whenPressed(new ToggleKidnapCommand());
		
		
		gamepad.b_button.whileHeld(new FreeCommand());
		gamepad.leftBumper.whileHeld(new SnatchCommand());
		
        // instantiate the command used for the autonomous period
		
		/*SMART DASHBOARD*/
		SmartDashboard.putData(Scheduler.getInstance());
		
		//Elevator Stuff
		SmartDashboard.putNumber("Elevator Height", Robot.elevatorSubsystem.getHeight());
		inchesPerTick = prefs.getFloat("Competition: 1/28.5f || Practice: 1/63.9f", 1/28.5f);
		
		//Michael Jackson Stuff
		SmartDashboard.putBoolean("Reduced Intake Speed?", Robot.mjSubsystem.getProximity())
		;
		//Upper Carriage Stuff
		SmartDashboard.putBoolean("Is it Poking?", Robot.upperCarriageSubsystem.isPoking());
		
		//Drive Stuff
		SmartDashboard.putNumber("Left Velocity", Robot.driveSubsystem.getLeftVelocity());
		SmartDashboard.putNumber("Right Velocity", Robot.driveSubsystem.getRightVelocity());
		speedModifier = prefs.getDouble("Speed Modifier", 1.0);
		
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
        // schedule the autonomous command (example)
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
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
