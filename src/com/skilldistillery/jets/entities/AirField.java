package com.skilldistillery.jets.entities;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AirField {
	private List<Jet>jets = new ArrayList<>();
	String fileName = "jets.txt";
	
	public AirField(List<Jet> jets) {
		super();
		this.jets = jets;
	}
	
	public AirField() {
		jets = new ArrayList<>();
	}
	

	public List<Jet> loadJets() {
    try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName)) ) {
        String line;
        Jet jet = null;
        while ((line = bufIn.readLine()) != null) {
          String[] jetRecord = line.split(", ");
          if(jetRecord[0].equals("cargo")) {
        	  System.out.println("Cargo");
        	  jet = new CargoPlane(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  jets.add(jet);
          }
          else if(jetRecord[0].equals("harrier")) {
        	  jet = new HarrierJet(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  jets.add(jet);
          }
          else if(jetRecord[0].equals("fighter")) {
        	  jet = new FighterJet(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  jets.add(jet);
          }
          else if(jetRecord[0].equals("jet")) {
        	  jet = new JetImp(jetRecord[1], Integer.parseInt(jetRecord[2]), Integer.parseInt(jetRecord[3]), Double.parseDouble(jetRecord[4]));
        	  jets.add(jet);
          }
        } 
      }
      catch (IOException e) {
        System.err.println(e);
      }
    return jets;
	}
    public List<Jet> getJets() {
    	return jets;
    }
    
    @Override
    public String toString() {
    	return "test" + jets
    			+ "]";
	}

	public void setJets(List<Jet> jets) {
		this.jets = jets;
	}
}
