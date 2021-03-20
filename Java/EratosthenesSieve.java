/*  Avi W
    ICS3U
    Mrs. Gaffoor
    Friday January 8, 2021
*/

/*  Eratosthenes Sieve
    Inputs a limit and determines if the number
    the user inputs is a prime number or not.
*/

//Importing packages that I need to use
import java.util.Arrays;
import java.util.Scanner;

public class EratosthenesSieve {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in); //initializing scanner package

        System.out.println("Welcome to the Eratosthenes' Sieve program!");

        System.out.print("Please enter the size limit: ");
        int limit = input.nextInt(); //getting the limit

        System.out.printf("\nEnter a number between 2 and %d to see if it's primes or not.", limit);
        System.out.println("\nTo exit, enter a negative number.\n");
        //Explaining how the program works.

        boolean[] primes = new boolean[limit+1]; //Creating a boolean list

        for(int i = 0; i < limit; i++) {
            primes[i] = true;
        }

        for(int num = 2; num * num <= limit; num++) {
            // If primes[num] is not changed, the   n it is a prime number
            if(primes[num]) {
                // Update all multiples of num
                for(int i = num * num; i <= limit; i += num)
                    primes[i] = false;
            }
        }

        int[] primeNumbers = {};

        // Add all the prime numbers to a list
        for(int i = 2; i <= limit; i++)
        {
            if(primes[i]) {
                primeNumbers = Arrays.copyOf(primeNumbers, primeNumbers.length + 1);
                primeNumbers[primeNumbers.length - 1] = i;
            }
        }

        //The running program that the user will see.
        while (true){
            System.out.print("Enter a number: ");
            int number = input.nextInt();

            if (number < 0){
                break;
            }

            boolean prime = false;

            for (int element : primeNumbers) {
                if (element == number) {
                    prime = true;
                    break;
                }
            }

            if (prime){
                System.out.println(number + " is a prime number.\n");
            } else {
                System.out.println(number + " is not a prime number.\n");
            }
        }
    }
}
