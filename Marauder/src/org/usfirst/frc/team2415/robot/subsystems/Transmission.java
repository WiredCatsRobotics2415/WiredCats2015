package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Encoder;

public class Transmission {
	
	private final float TICK_TO_FEET = 0;
	
	private Talon talon1, talon2;
	private Encoder encoder;
	
	public Transmission(int[] talons, int[] encoder){
		talon1 = new Talon(talons[0]);
		talon2 = new Talon(talons[1]);
		//this.encoder = new Encoder(encoder[0], encoder[1]);
	}
	
	public void set(double value){
		talon1.set(value);
		talon2.set(value);
	}
	
	public void resetEncoder(){
		encoder.reset();
	}
	
	public float getRate(){
    	//returns a rate in feet per seconds
    	return TICK_TO_FEET*(float)encoder.getRate();
    }
	
	public float getDistance(){
	    //returns distance traveled in feet
	    return TICK_TO_FEET*(float)encoder.get();
	}
}
