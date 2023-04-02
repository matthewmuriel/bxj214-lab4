package com.example.bxj214_lab4.Model;

public class CrewMember {
    private String name;
    private String position;
    private String rank;
    private String species;
    private String assignment;

    /**
     * Constructor that builds the CrewMember object
     *
     * @param name The name of the crew member
     * @param position The position they hold on the starship
     * @param rank The rank they hold
     * @param species The species that the crew member is
     * @param assignment The starship that they are assigned to.
     */
    public CrewMember(String name, String position, String rank, String species, String assignment) {
        this.name = name;
        this.position = position;
        this.rank = rank;
        this.species = species;
        this.assignment = assignment;
    }

    /**
     * Getter method to get the name of the CrewMember
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to get the position of the CrewMember
     * @return
     */
    public String getPosition() {
        return position;
    }

    /**
     * Getter method to get the rank of the CrewMember
     * @return
     */
    public String getRank() {
        return rank;
    }

    /**
     * Getter method to get the species of the CrewMember
     * @return
     */
    public String getSpecies() {
        return species;
    }

    /**
     * Getter method to get the assignment of the CrewMember
     * @return
     */
    public String getAssignment() {
        return assignment;
    }

    /**
     * toString method that arranges all of the CrewMember data correctly.
     */
    public String toString() {
        return "- " + getName() + " (" + getRank() + ") - " + getPosition() + " [" + getSpecies() + "]\n";
    }
}
