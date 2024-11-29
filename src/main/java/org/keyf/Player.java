package org.keyf;

public class Player {
    private Location currentLocation; // The player's current location
    private Inventory inventory; // The player's inventory
    private Character character; // The character the player is controlling

    // Constructor to initialize the player with their location, inventory, and character
    public Player(Location currentLocation, Inventory inventory, Character character) {
        this.currentLocation = currentLocation; // Set the current location
        this.inventory = inventory; // Set the player's inventory
        this.character = character; // Set the player's character
    }

    /** 
     * Public method that moves the player to a new location based on direction 
     */
    public void move(Location.Direction direction) {
        switch (direction) {
            case north:
                if (currentLocation.getExits().containsKey(Location.Direction.north)) {
                    currentLocation = currentLocation.getExits().get(Location.Direction.north); // Move north
                } else {
                    System.out.println("There is nothing in the North"); // Notify if no exit
                }
                break;
            case south:
                if (currentLocation.getExits().containsKey(Location.Direction.south)) {
                    currentLocation = currentLocation.getExits().get(Location.Direction.south); // Move south
                } else {
                    System.out.println("There is nothing in the South"); // Notify if no exit
                }
                break;
            case east:
                if (currentLocation.getExits().containsKey(Location.Direction.east)) {
                    currentLocation = currentLocation.getExits().get(Location.Direction.east); // Move east
                } else {
                    System.out.println("There is nothing in the East"); // Notify if no exit
                }
                break;
            case west:
                if (currentLocation.getExits().containsKey(Location.Direction.west)) {
                    currentLocation = currentLocation.getExits().get(Location.Direction.west); // Move west
                } else {
                    System.out.println("There is nothing in the West"); // Notify if no exit
                }
                break;
        }
    }

    /** 
     * Method for talking to a specified NPC 
     */
    public void talkTo(String npc) {
        for (Character ch : getCurrentLocation().getNpcs()) { // Iterate through NPCs in current location
            if (ch.getName().equalsIgnoreCase(npc)) { // Check for matching NPC name
                ch.say(); // Call the NPC's say method to talk
            }
        }
    }

    /** 
     * Method to check if all characters are going to the party 
     */
    public boolean hasWon() {
        boolean hasWon = true; // Start with true and check conditions
        for (Character ch : Wonderland.characterList) { // Iterate through all characters
            hasWon &= ch.isGoingToParty(); // Check if each character is going to the party
        }
        return hasWon; // Return whether all characters are going to the party
    }

    public Location getCurrentLocation() {
        return currentLocation; // Return the player's current location
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation; // Set a new current location for the player
    }

    public Inventory getInventory() {
        return inventory; // Return the player's inventory
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory; // Set a new inventory for the player
    }

    public Character getCharacter() {
        return character; // Return the character controlled by the player
    }

    public void setCharacter(Character character) {
        this.character = character; // Set a new character for the player
    }
}
