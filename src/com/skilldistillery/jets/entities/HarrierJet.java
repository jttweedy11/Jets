package com.skilldistillery.jets.entities;

public class HarrierJet extends Jet implements Combat {
	public HarrierJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	@Override
	public void fight() {
		System.out.println(this.getModel()+ " is inbound for the dogfight!");
	}
}
