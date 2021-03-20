/*  Avi W
    ICS3U
    Mrs. Gaffoor
    Wednesday November 25, 2020
*/

/*  Russian Peasant System
    This program gives a visual representation of the Russian Peasant System, a process for determining the product
    of 2 numbers. It then outputs the product of the two numbers. The first number given is multiplied by 2 and the
    second is divided by 2, until the second number is equal to 1. This only works with whole numbers.

    Program Guidelines:
    The user is prompted to enter 2 integers.
    Negative values will be rejected
    The program will keep running until 2 zeros are entered.
    The rows in which addition is required will be outputted.
 */

import java.util.Scanner; //Importing Scanner package

public class RussianPeasantSystem {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //Initiating Scanner
        System.out.println("Welcome to the Russian Peasant System program!\n"); //Greeting the user

        while (true) { //Creating a while loop to keep the program running until until the user asks it to stop.
            //Input
            System.out.print("Multiplier: ");
            float multiplier = input.nextFloat(); //asking for the multiplier (float)
            System.out.print("Multiplicand: ");
            float multiplicand = input.nextFloat(); //asking for the multiplicand (float)

            //Processing
            if (multiplier == 0 && multiplicand == 0){
                break; //if 2 zeros are entered, the program ends
            }

            float product = 0; //initializing the product variable

            if (multiplicand == 1) {
                System.out.printf("Product: %.0f\n", multiplier);
                // If one of the numbers is 0, the product is 0 and the algorithm isn't needed.
            } else if (multiplier < 0 || multiplicand < 0) {
                System.out.println("Values must not be negative.");
                //If one of the inputted numbers is negative, the program will output an error message
                multiplicand = 1; //So that the while loop does not initiate
            } else if (multiplier == 0 || multiplicand == 0) {
                System.out.println("Product: 0  ");
                multiplicand = 1; //So that the while loop does not initiate
                // If one of the numbers is 0, the product is 0 and the algorithm isn't needed.
            }

            if (multiplier % 1 != 0 || multiplicand % 1 != 0){
                multiplicand = 1; //Checks if the number is a decimal. If it is, it will restart the loop.
            }

            while (multiplicand != 1) {
                multiplier = multiplier * 2; //multiplier is multiplied by 2
                multiplicand = (float) Math.floor(multiplicand / 2); //multiplicand is divided by 2 and rounded down

                if (multiplicand % 2 != 0) { //only if the multiplicand is odd
                    System.out.printf("%.0f %.0f", multiplier, multiplicand); //prints the numbers currently
                    System.out.print("\n"); //Prints a newline character
                    product += multiplier; //adds the multiplier to the product
                }
            }

            //Output
            if (product > 1) { //Checks if the outcome hasn't already been outputted
                System.out.printf("Product: %.0f\n", product); //outputting the product
            }

            System.out.print("\n"); //prints a new line for clarity
        }
    }
}
