package org.keyf;

import org.apache.commons.io.IOUtils; // Importing IOUtils for reading files
import org.json.JSONObject; // Importing JSONObject for handling JSON data

import java.io.*; // Importing necessary classes for file handling
import java.util.ArrayList; // Importing ArrayList for dynamic array functionality
import java.util.HashMap; // Importing HashMap for storing exits
import java.util.List; // Importing List interface

public class Location {

    // Enum to define possible directions
    enum Direction {
        north, east, south, west,
    }

    private String name; // Name of the location
    private List<Item> items; // List of items in this location
    private List<Character> npcs; // List of non-player characters in this location
    private boolean isSafeHouse; // Flag to indicate if this location is a safe house
    public HashMap<Direction, Location> exits; // Map of exits in each direction
    private List<Item> itemsNeededForAVisit; // Items needed to visit this location

    // Method to store an item in this location
    public void storeItem(Item item) {
        if (!isSafeHouse) {
            System.out.println("It's not safe to store an item here"); // Notify if not a safe house
            return;
        }
        items.add(item); // Add the item to the list of items
        System.out.println("You stored " + item.getName()); // Notify that the item was stored
    }

    // Constructor that initializes the location from a JSON file
    Location(File file) {
        try {
            InputStream is = new FileInputStream(file); // Create input stream from file
            String jsonTxt = IOUtils.toString(is, "UTF-8"); // Read the file content as a string
            JSONObject LocObj = new JSONObject(jsonTxt); // Parse the string into a JSON object
            
            this.name = (String) LocObj.get("Name"); // Get the location's name from JSON
            this.isSafeHouse = (boolean) LocObj.get("SafeHouse"); // Get safe house status from JSON
            this.items = new ArrayList<>(); // Initialize the items list
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for any exceptions
        }
    }

    // Method to generate connections (exits) based on a JSON file
    public void generateConnections(File file) {
        try {
            InputStream is = new FileInputStream(file); // Create input stream from file
            String jsonTxt = IOUtils.toString(is, "UTF-8"); // Read the file content as a string
            JSONObject LocObj = new JSONObject(jsonTxt); // Parse the string into a JSON object
            
            this.exits = new HashMap<>(); // Initialize exits map
            
            if (!(LocObj.get("North")).equals("")) { 
                exits.put(Direction.north, Wonderland.getLocation((String) (LocObj.get("North")))); 
            }
            if (!(LocObj.get("West")).equals("")) { 
                exits.put(Direction.west, Wonderland.getLocation((String) (LocObj.get("West")))); 
            }
            if (!(LocObj.get("East")).equals("")) { 
                exits.put(Direction.east, Wonderland.getLocation((String) (LocObj.get("East")))); 
            }
            if (!(LocObj.get("South")).equals("")) { 
                exits.put(Direction.south, Wonderland.getLocation((String) (LocObj.get("South")))); 
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for any exceptions
        }
    }

    public String getName() {
        return name; // Return the name of the location
    }

    public void setName(String name) {
        this.name = name; // Set the name of the location
    }

    public List<Item> getItems() {
        return items; // Return the list of items in this location
    }

    public void setItems(List<Item> items) {
        this.items = items; // Set the list of items in this location
    }

    public List<Character> getNpcs() {
        return npcs; // Return the list of NPCs in this location
    }

    public void setNpcs(List<Character> npcs) {
        this.npcs = npcs; // Set the list of NPCs in this location
    }

    public boolean isSafeHouse() {
        return isSafeHouse; // Return whether this location is a safe house
    }

    public void setSafeHouse(boolean safeHouse) {
        isSafeHouse = safeHouse; // Set whether this location is a safe house
    }

    public HashMap<Direction, Location> getExits() {
        return exits; // Return the map of exits from this location
    }

    public void setExits(HashMap<Direction, Location> exits) {
        this.exits = exits; // Set the map of exits from this location
    }

    public List<Item> getItemsNeededForAVisit() {
        return itemsNeededForAVisit; // Return items needed for visiting this location
    }

    public void setItemsNeededForAVisit(List<Item> itemsNeededForAVisit) {
        this.itemsNeededForAVisit = itemsNeededForAVisit; // Set items needed for visiting this location
    }

    public Item getItem(String name) {
        for (Item i : this.items) { 
            if (i.getName().equals(name)) { 
                items.remove(i); // Remove and return the item if found
                return i;
            }
        }
        return null; // Return null if item not found
    }
}
