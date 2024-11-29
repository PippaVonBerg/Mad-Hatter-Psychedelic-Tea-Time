package org.keyf;

import java.io.*;
import java.util.HashMap;

public class TextUtil {

    public static void printInstructions() {
        // Create FileReader and BufferedReader objects to read the instructions from a file
        try (BufferedReader br = new BufferedReader(new FileReader("texts/instructions.txt"))) {
            StringBuilder instructions = new StringBuilder(); // Use StringBuilder for performance
            String line;

            // While there are still lines to read in the file, append them to instructions
            while ((line = br.readLine()) != null) {
                instructions.append(line).append('\n'); // Append each line with a newline
            }

            // Print the instructions
            System.out.println(instructions.toString());

        } catch (IOException e) {
            // If the file is not found, display an error message
            System.out.println("Error reading file. Please check the filename and try again.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    public static void printHelp() {
        // Create FileReader and BufferedReader objects to read help text from a file
        try (BufferedReader br = new BufferedReader(new FileReader("texts/help.txt"))) {
            StringBuilder helpText = new StringBuilder(); // Use StringBuilder for performance
            String line;

            // While there are still lines to read in the file, append them to helpText
            while ((line = br.readLine()) != null) {
                helpText.append(line).append('\n'); // Append each line with a newline
            }

            // Print the help text
            System.out.println(helpText.toString());

        } catch (IOException e) {
            // If the file is not found, display an error message
            System.out.println("Error reading file. Please check the filename and try again.");
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    /** Public static method to create the game actions */
    public static HashMap<String, Actions> createActions() {
        // Create FileReader and BufferedReader objects to read actions from a file
        try (BufferedReader br = new BufferedReader(new FileReader("texts/actions.txt"))) {
            HashMap<String, Actions> actions = new HashMap<>(); // Create a HashMap to store actions
            String line;

            // While there are still lines to read in the file
            while ((line = br.readLine()) != null) {
                // Split the line into main action name and action aliases
                String[] actionsList = line.split(",");
                String mainAction = actionsList[0].trim(); // Trim whitespace

                // Put main action name and Actions object in the HashMap
                actions.put(mainAction, new Actions(actionsList));

                // Read the next line
            }

            return actions; // Return the HashMap

        } catch (IOException e) {
            // If the file is not found, display an error message
            System.out.println("Error reading file. Please check the filename and try again.");
            e.printStackTrace(); // Print stack trace for debugging
            return null; // Return null on error
        }
    }
}
