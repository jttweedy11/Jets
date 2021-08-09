package com.skilldistillery.jets.app;


import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;

import java.util.Scanner;



public class JetsApplication {

	private AirField arf = new AirField();
	Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		JetsApplication ja = new JetsApplication();
		ja.run();
	}
	
	private void run() {
		// Create appropriate jets
		arf.loadJets();
		int selection = 0;
		while(selection !=9) {
			int option = selectionMenu();
			evaluateSelection(option);
		}
		System.out.println(arf.toString());
	}
	
	private void evaluateSelection(int userOption) {
		if(userOption == 1) {
			listFleet();
		}
		else if(userOption == 2) {
			flyFleet();
		}
		else if(userOption == 3) {
			fastestJet();
		}
		else if(userOption == 4) {
			
		}
		else if(userOption == 5) {
			
		}
		else if(userOption == 6) {
			
		}
		else if(userOption == 7) {
			
		}
		else if(userOption == 8) {
			
		}
		else if(userOption == 9) {
			quit();
		}
	}
		
	private int selectionMenu() {
		
		System.out.println("************************************************");
		System.out.println("	Welcome to the Jets App!					");
		System.out.println("Please choose from the following selection menu:");
		System.out.println("												");
		System.out.println("1. 		List fleet								");
		System.out.println("2. 		Fly all jets							");
		System.out.println("3. 		View fastest jet						");
		System.out.println("4. 		View jet with longest range				");
		System.out.println("5. 		Load all Cargo Jets						");
		System.out.println("6. 		Dogfight!								");
		System.out.println("7. 		Add a jet to Fleet						");
		System.out.println("8. 		Remove a jet from Fleet					");
		System.out.println("9. 		Quit"									);
		int uSelection = input.nextInt();
		return uSelection;
	}
	
	private void listFleet() {
		System.out.println("Here are the curent jets in the Airfield:");
		for(Jet jet : arf.getJets()) {
			System.out.println(jet);
		}
	}
	
	private void flyFleet() {
		System.out.println("All engines are hot!:");
		for(Jet jet : arf.getJets()) {
			jet.fly();
		}
	}
	
	private void fastestJet() {
		int fastSpeed = 0;
		Jet fastJet = null;
		for(Jet jet : arf.getJets()) {
			if(jet.getSpeed()>fastSpeed) {
			fastSpeed = jet.getSpeed();
			fastJet = jet;
			}
		}
		System.out.println("The fastest Jet is " + fastJet);
	}
	
	private void quit() {
		input.close();
		System.out.println("Sorry to see you go. Have a good day!");
	}
	}
////		CargoPlane c = new CargoPlane("boeing 747", 614, 8300, 50000);
//		FighterJet f = new FighterJet("F-22 Raptor", 1500, 1839, 60000);
//		HarrierJet h = new HarrierJet("Hawker Siddeley Harrier", 730, 1155, 30000);
//		double flightTime = f.calculateRange();
//		System.out.println(c.toString() + c.calculateRange());
//		System.out.println(f.toString() + f.calculateRange());
//		System.out.println(h.toString() + h.calculateRange());
		// Add to Airfield
//		arf.addJet(c);

