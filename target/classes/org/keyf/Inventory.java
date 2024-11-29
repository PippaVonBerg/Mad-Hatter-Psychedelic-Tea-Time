package org.keyf;

import java.util.ArrayList; // Importing ArrayList for dynamic array functionality
import java.util.List; // Importing List interface

public class Inventory {

    public List<Item> items; // List to store items in the inventory

    // Constructor to initialize the inventory
    public Inventory() {
        this.items = new ArrayList<>(); // Create a new ArrayList for items
    }

    // Method to add an item to the inventory
    public void addItem(Item item) {
        items.add(item); // Add the item to the list
    }

    // Method to check if the inventory has a specific item
    public boolean hasItem(String item, Character owner) {
        for (Item i : items) {
            // Check if the item's name matches (case insensitive)
            if (i.getName().equalsIgnoreCase(item)) {
                System.out.println("Yes, there is " + item + " in " + owner.getName() + "'s inventory");
                return true; // Item found
            }
        }
        System.out.println("Yes, there is NO " + item + " in " + owner.getName() + "'s inventory");
        return false; // Item not found
    }

    // Method to print all items in the inventory
    public void print() {
        for (Item i : items) {
            System.out.println(i.getName()); // Print each item's name
        }
    }

    // Method to fix a specific item in the inventory
    public void fixItem(String item) {
        for (Item i : items) {
            // Check if the item's name matches (case insensitive)
            if (i.getName().equalsIgnoreCase(item)) {
                i.fixItem(); // Call fixItem method on the found item
            }
        }
    }
}
