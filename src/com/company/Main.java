package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        /*

        Dear Mr. P,

        If you are reading this,
        Windows is better than Mac.

        Your favorite anarchist,
        Argen Detoito

         */

	    String [] board = {"-", "-", "-", "-", "-", "-", "-", "-", "-"};
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac O Jobs Know!\n");

        boolean looping = true; boolean yourTurn = true;

        boolean action = true;
        while (action) {
            System.out.println("Would you like to go first? Yes or No");
            String response = sc.nextLine().toLowerCase();
            if (response.equals("yes")) {
                yourTurn = true; action = false;
            } else if (response.equals("no")) {
                yourTurn = false; action = false;
            } else {
                System.out.println("Please input a valid answer.");
            }
        }

        int row = 1; int column = 1;

        DetermineLocation User = new DetermineLocation();

        while (looping) {
            if (yourTurn) {
                action = true;
                while (action) {
                    System.out.println("What row would you like to place your symbol?");
                    try {
                        row = sc.nextInt();
                        if (row >= 1 && row <= 3) {
                            action = false;
                        } else {
                            System.out.println("Number inputted is either lower than 1 or higher than 3.");
                            System.out.println("Please input a number between 1 and 3.");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("Not a number. Please input a number between 1 and 3.");
                    }
                }
                action = true;
                while (action) {
                    System.out.println("What column would you like to place your symbol?");
                    try {
                        column = sc.nextInt();
                        if (column >= 1 && column <= 3) {
                            action = false;
                        } else {
                            System.out.println("Number inputted is either lower than 1 or higher than 3.");
                            System.out.println("Please input a number between 1 and 3.");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("Not a number. Please input a number between 1 and 3.");
                    }
                }

                board[User.findLocation(row, column)] = "X";
                yourTurn = false;
            } else {
                board[AI.makeDecision(board)] = "O";
                yourTurn = true;
            }

            Match match = new Match();
            boolean isMatching = match.hasMatch(board);

            if (isMatching) {

            }
        }
    }
}
