/*  Avi W
    ICS3U
    Mrs. Gaffoor
    Monday January 25, 2021
*/

/*  Methods
    In this program there are 3 methods. The first is isPrime, which determines whether a given number
    is prime or not. The second method is sumOfPrimes. This method finds the sum of all prime numbers up to
    (but not including) a given number. The sumOfPrimes calls the isPrime method to run as it has to determine if
    the number it is adding to the sum is prime or not. The third method is factorial. The Factorial method returns
    the factorial of a number. For example, if the integer 4 is entered, it returns the result of 4x3x2x1. The
    factorial method only works for positive integer below 21 as it cannot compute numbers greater than 20.
*/


import java.util.Scanner;

public class Methods {
    public static void main(String[] args) {
        while (true) { //programming will keep running until the user says otherwise.
            System.out.println("Which method would you like to use?\n");
            System.out.println("- Type 1 to use the isPrime method");
            System.out.println("- Type 2 to use the sumOfPrime method");
            System.out.println("- Type 3 to use the Factorial method");
            Scanner input = new Scanner(System.in);
            int method = input.nextInt();
            System.out.print("\n");
            while (true) { //making sure the input that is entered is correct.
                if (method == 1 || method == 2 || method == 3) {
                    break;
                } else {
                    System.out.println("Invalid input. Which method would you like to use?");
                    method = input.nextInt();
                }
            }
            if (method == 1) {
                System.out.print("Enter an integer, I will tell you if it is prime or not: ");
                int primeNum = input.nextInt();
                if (isPrime(primeNum)) {
                    System.out.println(primeNum + " is prime.");
                } else {
                    System.out.println(primeNum + " is not prime.");
                }
            } else if (method == 2) {
                System.out.print("Enter an integer. I will return the sum of all the primes up to the number: ");
                int sumPrime = input.nextInt();
                System.out.println("The sum of all the prime numbers up to " + sumPrime + " is " +
                        sumOfPrime(sumPrime) + ".");
            } else {
                System.out.print("Enter an integer. I will return the factorial of that number: ");
                int factNum = input.nextInt();
                System.out.println("The factorial of " + factNum + " is " + Factorial(factNum) + ".");
            }

            System.out.println("\nWould you like to run the program again?");
            System.out.println("Type 'y' or 'n'.");
            String runAgain = input.next();
            //Asking the user if they want to run the program again
            if (runAgain.equals("n")) {
                break;
            }
        }
    }

    /**
     * Returns a boolean value which represents whether the given integer is prime or not.
     * <p>
     * If the integer is negative, 0, or 1, the program will automatically return false.
     * The program checks to see see if there are more than two factors by using the modulus operator.
     * If there are only 2, it returns true, or else it will return false.
     *
     * @param num an integer that the method determines if it is prime or not.
     * @return a boolean (true or false) whether num is prime or not
     */
    static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int factors = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) //checking if i is a factor of n
                factors += 1; //if it is, factors is increased by 1
        }

        return factors == 2; // if factors count is equals to 2 then it is prime number else it's not prime number
    }

    /**
     * Returns the sum of all prime numbers up to a given positive integer.
     * <p>
     * If the given limit is a prime number, it will include that number in the sum.
     * This method uses the isPrime method to determine whether each number up to the limit is prime.
     * If the number is prime, it will added to a running sum and returns that sum at the end.
     * Negative numbers, 0 and, 1 return a value of 0.
     *
     * @param limit an integer that is the highest number to be added to the sum if it is prime.
     * @return an integer that represents the sum of all the primes up to the limit inclusive.
     */
    static int sumOfPrime(int limit) {
        int sum = 0;
        //for each number up to the given number, it checks if it is prime using the isPrime method.
        for (int i = 0; i <= limit; i++) {
            boolean flag = isPrime(i);
            if (flag) { //if the number is prime, it is added to sum.
                sum += i;
            }
        }
        return sum; //returns the sum of all the prime numbers
    }

    /**
     * Returns the factorial of a given integer. For example, factorial 4, will return the result of 4x3x2x1.
     * <p>
     * If the given integer is 0 or a negative number, the method will return a value of 1.
     * This method has a limit of 20. Any number above 20 cannot be computed by the program.
     * Using recursion, the method will keep on calling itself until the number has been multiplied by every
     * number less than it ending at 1.
     *
     * @param number an integer that the method calculates the factorial of.
     * @return an integer that is equal to the factorial of the given integer
     */
    static long Factorial(int number) {
        if (number > 1) {
            return number * Factorial(number - 1); //number is multiplied by the factorial of (number - 1)
        } else {
            return 1;
            //will stop the loop because the number has finally been multiplied by every preceding positive integer.
        }
    }
}