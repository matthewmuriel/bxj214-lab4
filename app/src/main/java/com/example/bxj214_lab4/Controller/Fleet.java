package com.example.bxj214_lab4.Controller;

import android.content.res.AssetManager;

import com.example.bxj214_lab4.Model.Starship;

import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class Fleet {
    private ArrayList<Starship> starShips;

    /**
     * This method is a constructor for the Fleet class
     */
    public Fleet() {
        this.starShips = new ArrayList<Starship>();
    }

    /**
     * A method that adds a starship object to the ArrayList starShips
     *
     * @param s
     */
    public void addStarShip(Starship s) {
        starShips.add(s);
    }

    /**
     * Method for loading the Starship CSV files one at a time.
     * Scans the file for the first 3 strings and creates a crew list array based on the remaining information
     * A new starship object is then created based on the information.
     * After creation it then calls addStarShip to add the object to the starShips ArrayList
     * @throws RuntimeException
     */
    public void loadStarship(AssetManager manager){
        Scanner scan = null;
        try {
            InputStream file = manager.open("fleet.csv");
            scan = new Scanner(file);
            String line = "";
            String[] tokens;
            while(scan.hasNextLine()) {
                line = scan.nextLine();
                tokens = line.split(",");
                Starship ship = new Starship(tokens[0], tokens[1], tokens[2]);
                ship.buildRoster(manager);
                starShips.add(ship);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter method that gets the name of all of the starships
     *
     * @return returns the contents of all of the starship objects
     */
    public String getShipData(String reg) {
        String ship = "";
        for (Starship s : starShips) {
            if (s.getRegistry().equals(reg)){
                ship = s.getShipName();
            }
        }
        return ship;
    }

    public ArrayList<String> crewlist(String reg){
        ArrayList<String> roster = new ArrayList<String>();
        for (Starship s : starShips) {
            if (s.getRegistry().equals(reg)){
                roster.addAll(s.roster());
            }
        }
        return roster;
    }

    /**
     * A Getter Method that return the size of the starShips ArrayList
     *
     * @return int Returns an int of the size of the starShips ArrayList
     */
    public int getSizeOfFleet() {
        return starShips.size();
    }
}