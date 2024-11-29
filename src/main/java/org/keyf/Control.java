package org.keyf;

import java.util.HashMap; // Importing HashMap for storing valid actions

public class Control {

    /** 
     * Public static method to check whether or not an action is valid 
     * @param command The user input command to check
     * @param validActions A HashMap containing valid actions and their corresponding Actions objects
     * @return The valid action if found, otherwise null
     */
    public static String checkInput(String command, HashMap<String, Actions> validActions) {

        // Iterate over each valid action in the HashMap
        for (String action : validActions.keySet()) {

            // Iterate over each valid action alias in the Actions object
            for (String actionAlias : validActions.get(action).getActions()) {

                // If the user input matches a valid action alias, return the corresponding action
                if (actionAlias.equals(command)) {
                    return action; // Return the matched action
                }
            }
        }

        // If the user input does not match any valid actions, return null
        return null; // No valid action found
    }

}
