package com.example.bxj214_lab4.Model;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starship object class containing all of the methods to build out the starship information
 *
 * @author Matthew Muriel bxj214
 * UTSA CS 3443 - Lab 2
 * Spring 2023
 */
public class Starship {
    private String shipName;
    private String registry;
    private String starShipClass;
    private ArrayList<CrewMember> crewMembers;

    /**
     * Constructor method for the Starship object.
     * Loads the strings into the object variables
     * Will attempt to load crewmembers if the crewData ArrayList is not empty.
     * @param name of the starship
     * @param reg Registration of the starship
     * @param shipClass The class of the Starship
     */
    public Starship(String name, String reg, String shipClass) {
        this.shipName = name;
        this.registry = reg;
        this.starShipClass = shipClass;
        this.crewMembers = new ArrayList<CrewMember>();
    }
    /**
     * Method to add a CrewMember object to the array list crewMembers
     * @param c crew member object
     */
    public void addCrewMember(CrewMember c) {
        crewMembers.add(c);
    }

    /**
     * Method to build a crew member roster based on the Crew Data gathered from the starship CSV
     * Will tokenize the crew member lines and load the information into the CrewMember constructor
     * It then calls addCrewMember to add the CrewMember object to the crewMembers array list
     * @param manager to access personnel file
     */
    public void buildRoster(AssetManager manager) {
        Scanner scan = null;
        try {
            InputStream file = manager.open("personnel.csv");
            scan = new Scanner(file);
            String line = "";
            String[] tokens;
            while(scan.hasNextLine()){
                line = scan.nextLine();
                tokens = line.split(",");
                if (tokens[3].equals(getRegistry())){
                    crewMembers.add(new CrewMember(tokens[0],tokens[1],tokens[2],tokens[4],tokens[3]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * To string method that displays the all of the starship information
     */
    public String toString() {
        return getShipName() + ", " + getStarShipClass() + ". Registry: " + getRegistry() + "\n" +
                getNumberOfPersonnel() + " crew members assigned.\n"+
                getCrewMembers() + "\n";
    }

    /**
     * Getter method to get the ship name
     * @return Returns the ship name
     */
    public String getShipName() {
        return shipName;
    }

    /**
     * Getter method to get the ship registry
     * @return Returns a string of the ship registry
     */
    public String getRegistry() {
        return registry;
    }

    /**
     * Getter method to get the class of the starship
     * @return Returns a string of starship class
     */
    public String getStarShipClass() {
        return starShipClass;
    }

    /**
     * Getter method to get the number of personal
     * @return Returns an int of the size of crewMembers arraylist
     */
    public int getNumberOfPersonnel() {
        if (crewMembers.isEmpty()) {
            return 0;
        }
        else {
            return crewMembers.size();
        }
    }

    /**
     * Getter method to get a list of all of the crew members on the starship
     * @return Returns a string of all of the crew members on the starship
     */
    public String getCrewMembers() {
        String crewLog = "";
        for (CrewMember c:crewMembers) {
            crewLog += c;
        }
        return crewLog;
    }

    public ArrayList<String> roster(){
        ArrayList<String> roster = new ArrayList<String>();

        for (CrewMember c : crewMembers){
            roster.add(c.toString());
        }
        return roster;
    }

}


