package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet implements LoadCargo {
	public CargoPlane(String model, int speed, int range, double price) {
		super(model, speed, range, price);
	}
	
	@Override
	public void loadCargo() {
		System.out.println(this.getModel()+ " is loading it's cargo.");
	}
	

}

