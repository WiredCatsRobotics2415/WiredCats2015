package org.usfirst.frc.team2415.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;

public class Transmission {
	
	private CANTalon talon1, talon2;
	
	public Transmission(int talon1, int talon2){
		this.talon1 = new CANTalon(talon1);
		this.talon2 = new CANTalon(talon2);
	}
	
	public void set(double value){
		talon1.set(value);
		talon2.set(value);
	}
}
