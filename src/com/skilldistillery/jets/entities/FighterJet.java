package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements Combat {
	
	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	@Override
	public void fight() {
		System.out.println(this.getModel()+ " is loose for the dogfight!");
	}
	

}
