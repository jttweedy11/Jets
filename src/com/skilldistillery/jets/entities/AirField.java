package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class AirField {
	private Jet[] jets;
	private int numOfPlanes;
	String fileName = "jets.txt";
	
	private static int Max_Planes = 10;
	
	public AirField() {
		jets = new Jet[Max_Planes];
	}
	
	public void addJet(Jet jet) {
		jets[numOfPlanes] = jet;
		numOfPlanes++;
	}
	
	public Jet[] getJets() {
		Jet[] jetCopy;
		jetCopy = new Jet[numOfPlanes];
		for(int i=0;i<numOfPlanes;i++) {
			jetCopy[i] = jets[i];
		}
		return jetCopy;
	}
	
	@Override
	public String toString() {
		return "AirField [jets=" + Arrays.toString(jets) + ", numOfPlanes=" + numOfPlanes + ", fileName=" + fileName
				+ "]";
	}

	public void loadJets() {
    try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
        String line;
        Jet jet = null;
        while ((line = bufIn.readLine()) != null) {
          String[] jetRecord = line.split(", ");
//          System.out.println(jetRecord[0]);
//          System.out.println(jetRecord[1]);
//          System.out.println(jetRecord[2]);
//          System.out.println(jetRecord[3]);
//          System.out.println(jetRecord[4]);
          if(jetRecord[0].equals("cargo")) {
        	  System.out.println("Cargo");
        	  jet = new CargoPlane(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  addJet(jet);
          }
          else if(jetRecord[0].equals("harrier")) {
        	  jet = new HarrierJet(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  addJet(jet);
          }
          else if(jetRecord[0].equals("fighter")) {
        	  jet = new FighterJet(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  addJet(jet);
          }
          else if(jetRecord[0].equals("jet")) {
        	  jet = new JetImp(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  addJet(jet);
          }
        } 
      }
      catch (IOException e) {
        System.err.println(e);
      }
	}
}
