// Import scanner class to get input.
import java.util.Scanner;

// Import random class for functionalities
import java.util.Random;
//import java.io.*;
//import java.util.*;
/** .
* Dice game from 1-6, loops until user guesses right.
*
* @author  Zak Goneau
* @version 1.0
* @since   2025-02-27
*/

// Creating class
public final class DiceGame {

    /**
     * This is a private constructor used to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private DiceGame() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) {

        // Declare variables
        int counter = 0;
        String userGuessString = "";
        int userGuess = 0;
        int max = 6;
        int min = 1;
        int randNumber;

        // Create instance of random class
        Random rand = new Random();

        // Get random number from 1-6, inclusive
        randNumber = rand.nextInt(max - min + 1) + min;

        // Welcome and get user input
        System.out.print("This is a dice game, 1-6.");
        System.out.println(" You must guess until you get it correct. ");

        // Create scanner object
        Scanner scanner = new Scanner(System.in);

        // Do while loop
        do {
            // Using scanner to get user input
            System.out.println("Please enter a number (1-6): ");
            userGuessString = scanner.nextLine();

            // try converting guess to integer
            try {

                // Try casting input to integer and assigning to variable
                userGuess = Integer.parseInt(userGuessString);

                // Check if guess is out of range
                if (userGuess < 1 || userGuess > 6) {

                    // If out of range tell user
                    System.out.println(userGuess + " is not a ");
                    System.out.println("number from 1-6.");

                // Otherwise check if too high, low or correct
                } else {
                    // Check if guess is correct and print
                    if (userGuess == randNumber) {
                        // Increment counter
                        counter++;

                        // tell user correct guess
                        System.out.println("You guessed correct! It took "
                            + counter + " tries.");

                    // Check if user guess is too low
                    } else if (userGuess < randNumber) {
                        System.out.println("Your guess was too low.");

                        // Increment counter
                        counter++;

                    // Check if user guess is too high
                    } else {
                        System.out.println("Your number is too high");

                        // Increment counter
                        counter++;
                    }
                }

                // Catch invalid inputs and tell user
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid input. "
                        + error.getMessage());
            }

        // Loop while guess is wrong
        } while (userGuess != randNumber);

        // Close scanner
        scanner.close();
    }
}
