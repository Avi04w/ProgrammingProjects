/*  Avi W
    ICS3U
    Mrs. Gaffoor
    Friday January 29, 2021
*/

/* E-Waste Tic Tac Toe
 We had to come up with an idea and code for a software problem that can be useful to certain groups.
 My idea is a an educational game as it can benefit students and improve their learning experience.

 This game is a fun and interactive way to teach children about electronic waste! First, the students is asked
 5 multiple choice questions, and if they are able to get all of them right, they are rewarded by being able
 to play a game of Tic Tac Toe against the computer. They can play Tic Tac Toe against the computer as
 many times as they want, as it is in while loop and can be exited whenever they want.
*/

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int correct = 0;

        //Question 1
        System.out.println("What is electronic waste?\n" +
                "A) Electronic waste describes discarded electrical or electronic devices.\n" +
                "B) Used electronic which are destined for refurbishment, reuse, resale, or disposal.\n" +
                "C) Electronic products nearing the end of their 'useful life'.\n" +
                "D) All of the above."); //Answer: D
        String answer1 = input.next();
        if (answer1.equals("d") || answer1.equals("D")){
            System.out.println("Correct!\n");
            correct += 1;
        } else {
            System.out.println("Incorrect!\n");
        }

        //Question 2
        System.out.println("Where do most of the electronics we throw out end up?\n" +
                "A) Properly disposed and recycled.\n" +
                "B) Landfills in other countries.\n" +
                "C) The Ocean.\n" +
                "D) Space."); //Answer: B
        String answer2 = input.next();
        if (answer2.equals("b") || answer2.equals("B")){
            System.out.println("Correct!\n");
            correct += 1;
        } else {
            System.out.println("Incorrect!\n");
        }

        //Question 3 
        System.out.println("Which of the following is not a negative effect of e-waste on the environment?\n" +
                "A) The have many toxins that are harmful to human health.\n" +
                "B) Chemicals in the electronics can contaminate the water.\n" +
                "C) Some of the processes used to remove valuable parts cause air pollution.\n" +
                "D) Chemicals can can seep into the soil, which can destroy the local crops\n" +
                "E) None of the above."); //Answer: E
        String answer3 = input.next();
        if (answer3.equals("e") || answer3.equals("E")){
            System.out.println("Correct!\n");
            correct += 1;
        } else {
            System.out.println("Incorrect!\n");
        }

        //Question 4
        System.out.println("Which of the following is not a way to protect the environment and reduce E-waste?\n" +
                "A) Storing your data on hard drives and other storage devices instead of online.\n" +
                "B) Giving your old cellphone to someone who needs it instead of throwing it out.\n" +
                "C) Taking your product to a recycler who properly disposes of your product.\n" +
                "D) Downloading your software instead of buying a CD.\n" +
                "E) None of the above."); //Answer: A
        String answer4 = input.next();
        if (answer4.equals("a") || answer4.equals("A")){
            System.out.println("Correct!\n");
            correct += 1;
        } else {
            System.out.println("Incorrect!\n");
        }

        //Question 5
        System.out.println("Why is there so little being done about E-waste?\n" +
                "A) It isn't illegal.\n" +
                "B) Most of the waste is shipped to third-world countries where the laws are more lenient.\n" +
                "C) Most of E-waste is properly recycled, only a small portion is discarded improperly."); //Answer: B
        String answer5 = input.next();
        if (answer5.equals("b") || answer5.equals("B")){
            System.out.println("Correct!\n");
            correct += 1;
        } else {
            System.out.println("Incorrect!\n");
        }

        boolean playing = false;

        //Checking if all the answers is correct.
        if (correct == 5){
            System.out.println("Congrats! all of your answers were correct. You can now play the computer in a " +
                    "game of Tic Tac Toe!");
            playing = true; //The Tic Tac Toe game will now run
        } else {
            System.out.println("Sorry! You didn't answer all the questions correctly, better luck next time!");
        }

        while (playing){
            System.out.println("\nWelcome to Tic Tac Toe!");
            System.out.println("You will be 'X' and I will be 'O'");
            System.out.println("You go first!\n");

            int[] takenSpaces = {};
            String[] gameBoard = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
            makeBoard(gameBoard);
            boolean gameRunning = true;

            while (gameRunning) { //The while loop resets after every loop.
                int pMove = playerMove(); //get the player move

                //Making sure the given move is in the range (1-9).
                boolean inRange = false;
                while (!inRange){
                    if (pMove > 8 || pMove < 0) {
                        System.out.println("That is not a valid move");
                        pMove = playerMove();
                    } else {
                        inRange = true;
                    }
                }

                //Making sure the given move is not for a taken space.
                boolean correctInput = false;
                while (!correctInput) {
                    boolean taken = false;
                    for (int move : takenSpaces){
                        if (pMove == move) {
                            taken = true;
                            break;
                        }
                    }

                    if (taken) {
                        System.out.println("That space is already taken");
                        pMove = playerMove();
                    } else {
                        takenSpaces = Arrays.copyOf(takenSpaces, takenSpaces.length + 1);
                        takenSpaces[takenSpaces.length - 1] = pMove;
                        //If the space isn't taken, it's added to the list of taken spaces.
                        correctInput = true;
                    }
                }

                makeMove(gameBoard, "X", pMove); //The move is made.
                boolean win = checkWinner(gameBoard, "X"); //Checks if the player won.

                if (win){
                    System.out.println("Congratulations, You Win!\n");
                    break;
                } else if (boardIsFull(gameBoard)){
                    makeBoard(gameBoard);
                    System.out.println("We Tied!\n");
                    break;
                }

                int cMove = compMove(gameBoard); //Gets the computer move
                makeMove(gameBoard, "O", cMove); //Makes the computer move
                makeBoard(gameBoard); //Prints the board for the user to see
                takenSpaces = Arrays.copyOf(takenSpaces, takenSpaces.length + 1);
                takenSpaces[takenSpaces.length - 1] = cMove; //Adds the computer move to the taken moves list
                win = checkWinner(gameBoard, "O"); //Checks if the computer has won
                if (win) {
                    System.out.println("I Win! Better luck next time!\n");
                    gameRunning = false;
                }
            }

            //After the game is over, the program asks the player if they want to play again.
            System.out.println("Do you want to play again? Type 'n' to exit or anything else to continue.");
            String playAgain = input.next();
            if (playAgain.equals("n")){
                playing = false;
            }
        }

        System.out.println("Thanks for playing! I hope you have learned a lot about e-waste!");
    }

    /**
     * This function prints the game for the user to see
     * <p>
     * A list with the current states of each box is entered and the method prints it out for the user to see.
     * This method doesn't return anything, it only prints so there is a void parameter.
     *
     * @param board A list of strings that is the current game board
     */
    static void makeBoard(String[] board){
        System.out.println(" " + board[0] + " | " + " " + board[1] + " | " + " " + board[2]);
        System.out.println("-------------");
        System.out.println(" " + board[3] + " | " + " " + board[4] + " | " + " " + board[5]);
        System.out.println("-------------");
        System.out.println(" " + board[6] + " | " + " " + board[7] + " | " + " " + board[8] + "\n");
    }

    /**
     * This method gets what move the player wants to do.
     * <p>
     * The program asks the player which box they want to move in, and then returns that number - 1 (as
     * list indexing starts at 0 and the boxes are labelled 1-9 for the player).
     * This method does not need any parameters for it to run.
     *
     * @return an int that represents which box the player wants to put the 'X' in.
     */
    static int playerMove(){
        Scanner input = new Scanner(System.in);
        System.out.print("Type in a number from 1-9 (from top left to right bottom) to place your X on the board: ");
        int playerMove = input.nextInt();
        return playerMove - 1;
    }

    /**
     * This method checks if a space on the board is free and returns a boolean.
     *
     * @param board A list of strings that is the current game board
     * @param space an int that represents a space on the board.
     * @return a boolean (true or false) if the given space is free or not.
     */
    static boolean freeSpace(String[] board, int space){
        return board[space].equals(" ");
    }

    /**
     * This method makes a copy of the current board an returns it.
     *
     * @param board A list of strings that is the current game board
     * @return A list of strings that is a copy of the current board.
     */
    static String[] getBoardCopy(String[] board){
        String [] copyBoard = new String[9];
        System.arraycopy(board, 0, copyBoard, 0, 9);
        return copyBoard;
    }

    /**
     * This method checks to see if a player has won.
     * <p>
     * It checks all the possible combinations of winning possibilities and returns if any of them have occurred.
     * it returns true if any of the winning possibilities have occurred and false if none of them have occurred.
     *
     * @param board A list of strings that is the current game board
     * @param mark a string ('X' or 'O') for which player the game is checking for.
     * @return a boolean if the game has been won or not.
     */
    static boolean checkWinner(String[] board, String mark){
        return (board[0].equals(mark) && board[1].equals(mark) && board[2].equals(mark)) ||
                (board[3].equals(mark) && board[4].equals(mark) && board[5].equals(mark)) ||
                (board[6].equals(mark) && board[7].equals(mark) && board[8].equals(mark)) ||
                (board[0].equals(mark) && board[3].equals(mark) && board[6].equals(mark)) ||
                (board[1].equals(mark) && board[4].equals(mark) && board[7].equals(mark)) ||
                (board[2].equals(mark) && board[5].equals(mark) && board[8].equals(mark)) ||
                (board[2].equals(mark) && board[4].equals(mark) && board[6].equals(mark)) ||
                (board[0].equals(mark) && board[4].equals(mark) && board[8].equals(mark));
    }

    /**
     * This method gets the computer's move.
     * <p>
     * The computer will make the best possible move always. First it checks if there are any winning possibilities.
     * Then, if there are any possibilities for the player to win and blocks it.
     * Next, it checks if the middle space is open, followed by the corners, then finally the side spaces.
     *
     * @param board A list of strings that is the current game board
     * @return an integer that represents the computer's move
     */
    static int compMove(String[] board){
        for (int i = 0; i < 9; i++) {
            String[] copy = getBoardCopy(board);
            if (freeSpace(copy, i)) {
                copy[i] = "O";
                if (checkWinner(copy, "O")) {
                    return i;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            String[] copy = getBoardCopy(board);
            if (freeSpace(copy, i)) {
                copy[i] = "X";
                if (checkWinner(copy, "X")) {
                    return i;
                }
            }
        }

        if (freeSpace(board, 4)) {
            return 4;
        }

        int[] cornerMoves = {4, 0, 2, 6, 8};
        for (int i : cornerMoves) {
            if (freeSpace(board, i)) {
                return i;
            }
        }

        int[] sideMoves = {1, 3, 5, 7};
        for (int i : sideMoves) {
            if (freeSpace(board, i)) {
                return i;
            }
        }

        return 0;
    }

    /**
     * This method updates the game board when the player or computer makes a move.
     *
     * @param board A list of strings that is the current game board
     * @param mark a string ('X' or 'O').
     * @param space a int that represents a space on the board (0-8).
     */
    static void makeMove(String[] board, String mark, int space){
        board[space] = mark;
    }

    /**
     * This method checks if the game board is full, at which point, the game would be over.
     *
     * @param board A list of strings that is the current game board
     * @return a boolean (true or false) if the board is full.
     */
    static boolean boardIsFull(String[] board){
        for (String i : board){
            if (i.equals(" ")){
                return false;
            }
        }
        return true;
    }
}
