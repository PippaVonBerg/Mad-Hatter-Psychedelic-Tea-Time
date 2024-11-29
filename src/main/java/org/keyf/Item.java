package org.keyf;

import java.util.List; // Importing List for storing characters who need the item

public class Item {

    private String name; // Name of the item
    private boolean isFixed; // Status to check if the item is fixed
    private boolean isNeededForParty; // Status to check if the item is needed for the party
    private List<Character> whoNeeds; // List of characters who need this item

    // Constructor to initialize the item with a name
    public Item(String name) {
        this.name = name; // Set the item's name
        this.isFixed = false; // Initialize as not fixed
        this.isNeededForParty = false; // Initialize as not needed for party
    }

    // Method to fix the item
    public void fixItem() {
        if (isFixed) {
            System.out.println("Your " + name + " is already in good shape"); // Notify if already fixed
        } else {
            isFixed = true; // Set the item as fixed
            System.out.println(name + " was fixed"); // Notify that the item has been fixed
        }
    }

    // Getter method to retrieve the item's name
    public String getName() {
        return name; // Return the item's name
    }

    // Setter method to set a new name for the item
    public void setName(String name) {
        this.name = name; // Update the item's name
    }

    // Getter method to check if the item is fixed
    public boolean isFixed() {
        return isFixed; // Return the fixed status of the item
    }

    // Setter method to set the fixed status of the item
    public void setFixed(boolean fixed) {
        isFixed = fixed; // Update the fixed status of the item
    }

    // Getter method to retrieve who needs this item
    public List<Character> getWhoNeeds() {
        return whoNeeds; // Return list of characters who need this item
    }

    // Setter method to set which characters need this item
    public void setWhoNeeds(List<Character> whoNeeds) {
        this.whoNeeds = whoNeeds; // Update list of characters who need this item
    }
}
