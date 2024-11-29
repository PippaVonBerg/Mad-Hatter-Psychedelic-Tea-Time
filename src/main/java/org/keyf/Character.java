package org.keyf;

import org.apache.commons.io.IOUtils; // Importing IOUtils for reading files
import org.json.JSONObject; // Importing JSONObject for handling JSON data

import java.io.File; // Importing File class for file handling
import java.io.FileInputStream; // Importing FileInputStream for reading files
import java.io.InputStream; // Importing InputStream for input stream handling
import java.util.List; // Importing List for using lists
import java.util.Objects; // Importing Objects for object comparison

public class Character {

    private String name; // Character's name
    private List<Item> itemNeeded; // Items needed by the character
    private List<Item> itemWanted; // Items wanted by the character
    private String speech; // Character's speech text
    private boolean isGoingToParty; // Flag to check if character is going to the party

    // Constructor that initializes the character from a JSON file
    Character(File file) {
        try {
            InputStream is = new FileInputStream(file); // Create input stream from file
            String jsonTxt = IOUtils.toString(is, "UTF-8"); // Read the file content as a string
            JSONObject LocObj = new JSONObject(jsonTxt); // Parse the string into a JSON object
            
            this.name = (String) LocObj.get("Name"); // Get the character's name from JSON
            this.isGoingToParty = false; // Initialize going to party status
            // Uncomment and implement location if needed: 
            // this.location = Wonderland.getLocation((String) LocObj.get("Location"));
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for any exceptions
        }
    }

    public boolean isGoingToParty() {
        return isGoingToParty; // Return whether the character is going to the party
    }

    public void setGoingToParty(boolean goingToParty) {
        isGoingToParty = goingToParty; // Set the going to party status
    }

    public void say() {
        System.out.println(speech); // Print the character's speech
    }

    public String getName() {
        return name; // Return the character's name
    }

    public void setName(String name) {
        this.name = name; // Set the character's name
    }

    public List<Item> getItemNeeded() {
        return itemNeeded; // Return items needed by the character
    }

    public void setItemNeeded(List<Item> itemNeeded) {
        this.itemNeeded = itemNeeded; // Set items needed by the character
    }
}
