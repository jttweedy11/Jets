package com.skilldistillery.jets.entities;

public class FighterJet extends Jet {
	
	public FighterJet(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}

	@Override
	public double calculateRange() {
		// TODO Auto-generated method stub
		double speed = super.getSpeed();
		double range = super.getRange();
		double result = 0.0;
		
		result = range/speed;
		return result;
	}
}
