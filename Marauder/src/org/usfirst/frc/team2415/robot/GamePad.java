/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team2415.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

/**
 *
 * @author Robotics
 */
public class GamePad extends Joystick{
    
    public JoystickButton a_button;
    public JoystickButton b_button;
    public JoystickButton x_button;
    public JoystickButton y_button;
    
    public JoystickButton rightBumper;
    public JoystickButton leftBumper;
    public Trigger leftTrigger;
    public Trigger rightTrigger;
    
    public GamePad(int port){
        super(port);
        a_button = new JoystickButton(this, 1);
        b_button = new JoystickButton(this, 2);
        x_button = new JoystickButton(this, 3);
        y_button = new JoystickButton(this, 4);
        
        rightBumper = new JoystickButton(this, 6);
        leftBumper = new JoystickButton(this, 5);
        
        leftTrigger = new Trigger(this, 2);
        rightTrigger = new Trigger(this, 3);
    }
    
    public double leftY(){
        return this.getRawAxis(1);
    }

    public double leftX(){
        return this.getRawAxis(0);
    }
    
    public double rightY(){
        return this.getRawAxis(5);
    }
    
    public double rightX(){
        return this.getRawAxis(4);
    }
    /*
    public boolean leftTrigger(){
        return this.getRawAxis(2) > 0.75;
    }
    
    public boolean rightTrigger(){
        return this.getRawAxis(3) > 0.75;
    }
    */
    public class Trigger extends JoystickButton{
    	
    	private GenericHID joystick;
    	private int triggerNumber;
    	
		public Trigger(GenericHID joystick, int triggerNumber) {
			super(joystick, triggerNumber);
			this.joystick = joystick;
			this.triggerNumber = triggerNumber;
		}
		
		public boolean get(){
			return joystick.getRawAxis(triggerNumber) > 0.75;
		}
    	
    }
}