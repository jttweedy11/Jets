package com.skilldistillery.jets.app;


import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.JetImp;

import java.util.List;
import java.util.InputMismatchException;
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
			longestFlightTime();
		}
		else if(userOption == 5) {
			addJet();
		}
		else if(userOption == 6) {
			removeJet();
		}
		else if(userOption == 7) {
			quit();
		}
		else
			System.out.println("Please enter a valid entry.");
	}
		
	private int selectionMenu() {
		
		System.out.println("************************************************");
		System.out.println("	Welcome to the Jets App!					");
		System.out.println("Please choose from the following selection menu:");
		System.out.println("												");
		System.out.println("1. 		List fleet								");
		System.out.println("2. 		Fly all jets							");
		System.out.println("3. 		View fastest jet						");
		System.out.println("4. 		View jet with longest flight time		");
		System.out.println("5. 		Add a jet to Fleet						");
		System.out.println("6. 		Remove a jet from Fleet					");
		System.out.println("7. 		Quit									");
		int uSelection = input.nextInt();
		return uSelection;
	}
	
	private void listFleet() {
		System.out.println("Here are the current Jets in the Airfield:");
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
	
	private void longestFlightTime() {
		double longestTime = 0.0;
		Jet longJet = null;
		for(Jet jet : arf.getJets()) {
			if(jet.getFlightTime()>longestTime) {
				longestTime = jet.getFlightTime();
				longJet = jet;
			}
		}
		System.out.println("The Jet with the longest flight time is " + longJet + ", Fligth Time:" + longestTime);
	}
	
	private void addJet() {
		try {
			System.out.println("Please enter the Model of the Jet:");
			input.nextLine();
			String model = input.nextLine();
			System.out.println("Please enter the speed of the Jet:");
			int speed = input.nextInt();
			System.out.println("Please enter range the Jet can fly without refueling:");
			int range = input.nextInt();
			System.out.println("Please enter the price of the Jet");
			double price = input.nextDouble();
			arf.getJets().add(new JetImp(model,speed,range,price));
			System.out.println("This plane has been added to the airfield.");
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid input");
			input.nextLine();
		}
		
	}
	
	public void removeJet() {
		List<Jet> jets = arf.getJets();
		for(int i = 0;i<jets.size();i++) {
			System.out.println(i + 1 + " - " + jets.get(i));
		}
		System.out.println("Please enter the number of the Jet you wish to remove:");
		try {
			int selection = input.nextInt();
			if(selection > 0 && selection < (jets.size() + 1)) {
			System.out.println("The following Jet will be removed from the airfield:" + jets.get(selection - 1));
			jets.remove(selection -1);
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input");
		}
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

