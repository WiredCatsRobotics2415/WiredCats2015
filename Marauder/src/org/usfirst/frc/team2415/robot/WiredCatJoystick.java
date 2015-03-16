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
public class WiredCatJoystick extends Joystick{
    
    public JoystickButton[] buttons = new JoystickButton[9];
    public JoystickButton trigger;
    
    public WiredCatJoystick(int port){
        super(port);
        
        for (int i = 0; i < buttons.length; i++){
        	buttons[i] = new JoystickButton(this, i+2);//2-10
        }
        
        trigger = new JoystickButton(this,1);
    }
    
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
