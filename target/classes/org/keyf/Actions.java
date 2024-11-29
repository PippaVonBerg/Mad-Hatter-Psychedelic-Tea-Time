package org.keyf;

public class Actions {

    /** Instance variable to keep track of valid actions */
    private String[] actions;

    /** Constructor for Actions class accepting a String array */
    public Actions(String[] actions) {
        // Initializes instance variable
        this.actions = actions;
    }

    /** Public getter method to return the valid actions */
    public String[] getActions() {
        return actions;
    }

    /** Method for speaking with a character */
    public void speak(Character character) {
        // Add logic for speaking with the character
    }

    /** Method for moving in a specified direction */
    public void move(Location.Direction dir) {
        // Add logic for moving in the specified direction
    }

    /** Method for examining a location */
    public void examine(Location location) {
        // Add logic for examining the location
    }

    /** Method for consuming an item */
    public void consume(Item item) {
        // Add logic for consuming the item
    }

    /** Method for picking up an item */
    public void pickUp(Item item) {
        // Add logic for picking up the item
    }

    /** Method for dropping an item */
    public void drop(Item item) {
        // Add logic for dropping the item
    }

    /** Method for storing an item */
    public void store(Item item) {
        // Add logic for storing the item
    }
}
