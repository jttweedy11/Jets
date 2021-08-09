package com.skilldistillery.jets.app;


import com.skilldistillery.jets.entities.AirField;



public class JetsApplication {
	private AirField airfield;
	
	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}
	
	private void run() {
		// Create appropriate jets
		AirField arf = new AirField();
		arf.loadJets();
////		CargoPlane c = new CargoPlane("boeing 747", 614, 8300, 50000);
//		FighterJet f = new FighterJet("F-22 Raptor", 1500, 1839, 60000);
//		HarrierJet h = new HarrierJet("Hawker Siddeley Harrier", 730, 1155, 30000);
//		double flightTime = f.calculateRange();
//		System.out.println(c.toString() + c.calculateRange());
//		System.out.println(f.toString() + f.calculateRange());
//		System.out.println(h.toString() + h.calculateRange());
		// Add to Airfield
//		arf.addJet(c);
		System.out.println(arf.toString());
	}
}

