/*  Avi W
    ICS3U
    Mrs. Gaffoor
    Monday October 19, 2020
*/

/*  Rock Paper Scissors
    Asks 2 users to enter their move in a game of rock paper scissors and outputs the winner.
 */

import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args){

        int p1wins = 0;
        int p2wins = 0;

        while (true) {
            Scanner move = new Scanner(System.in);

            System.out.print("Player 1, pick either rock, paper, or scissors: ");
            String player1 = move.nextLine();

            System.out.print("Player 2, pick either rock, paper, or scissors: ");
            String player2 = move.nextLine();

            if (!player1.equals("rock") && !player1.equals("paper") && !player1.equals("scissors")) {
                System.out.println("No Contest!");
            } else if (!player2.equals("rock") && !player2.equals("paper") && !player2.equals("scissors")) {
                System.out.println("No Contest!");
            }

            if (player1.equals("rock") && player2.equals("scissors")) {
                System.out.println("Player 1 wins!");
                p1wins += 1;
            } else if (player1.equals("paper") && player2.equals("rock")) {
                System.out.println("Player 1 wins!");
                p1wins += 1;
            } else if (player1.equals("scissors") && player2.equals("paper")) {
                System.out.println("Player 1 wins!");
                p1wins += 1;
            } else if (player1.equals(player2)) {
                System.out.println("Tie Game");
            } else {
                System.out.println("Player 2 wins!");
                p2wins += 1;
            }

            if (p1wins == 2){
                System.out.printf("Player 1 wins! %d games to %d", p1wins, p2wins);
                break;
            } else if (p2wins == 2) {
                System.out.printf("Player 2 wins! %d games to %d", p2wins, p1wins);
                break;
            }
        }
    }
}
