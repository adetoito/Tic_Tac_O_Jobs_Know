package com.company;

import java.util.*;

public class PvC {

    public static void beginGame (boolean order) {
        Scanner sc = new Scanner(System.in);
        boolean looping = true;
        int row = 1; int column = 1;
        String symbol;

        //String [] row1 = {"-", "-", "-"}; String [] row2 = {"-", "-", "-"}; String [] row3 = {"-", "-", "-"}; OLD
        String [][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

        while (looping) {
            System.out.println("\n" + board[0][0] + " " + board[0][1] + " " + board[0][2]);
            System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
            System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");
            if (order) {
                boolean action = true;
                symbol = "X";
                while (action) {
                    System.out.println("What row would you like to place your symbol?");
                    try {
                        row = sc.nextInt() - 1;
                        if (row >= 0 && row <= 2) {
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
                        column = sc.nextInt() - 1;
                        if (column >= 0 && column <= 2) {
                            action = false;
                        } else {
                            System.out.println("Number inputted is either lower than 1 or higher than 3.");
                            System.out.println("Please input a number between 1 and 3.");
                        }
                    } catch (InputMismatchException ime) {
                        System.out.println("Not a number. Please input a number between 1 and 3.");
                    }
                }

                /*
                if (row == 1) {
                    row1[DetermineLocation.findLocation(column)] = symbol;
                } else if (row == 2) {
                    row2[DetermineLocation.findLocation(column)] = symbol;
                } else {
                    row3[DetermineLocation.findLocation(column)] = symbol;
                }
                */
                board[row][column] = symbol;
                int hasMatch = Match.isMatching(board); // INT TO DETERMINE WINNER (0 = no match, 1 = P1 win, 2 = P2 win)

                if (hasMatch == 1) {
                    System.out.println("Player 1 wins!");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else if (hasMatch == 2) {
                    System.out.println("Player 2 wins!");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else {
                    if (order) {
                        order = false;
                    } else {
                        order = true;
                    }
                }
            } else {
                symbol = "O";
                int [] location = AI.getLocation(board);
            }

        }
    }
}
