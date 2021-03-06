package com.company;

import java.util.*;

public class PvC {

    public static void beginGame (boolean order) {
        Scanner sc = new Scanner(System.in);
        boolean looping = true;
        int row = 1; int column = 1;
        String symbol;

        String [][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

        while (looping) {
            System.out.println("\n" + board[0][0] + " " + board[0][1] + " " + board[0][2]);
            System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
            System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");
            if (order) {
                boolean action; boolean confirming = true;
                System.out.println("It is your turn!");
                symbol = "X";
                while (confirming) {
                    action = true;
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

                    if (board[row][column].equals("-")) {
                        board[row][column] = symbol;
                        confirming = false;
                    } else {
                        System.out.println("\nThis location already has a symbol in it. Input a valid location.");
                    }
                }

                board[row][column] = symbol;

                int hasMatch = Match.isMatching(board); // INT TO DETERMINE WINNER (0 = no match, 1 = P1 win, 2 = P2 win)
                boolean tie = Match.tieGame(board);

                if (hasMatch == 1 && !tie) {
                    System.out.println("Player 1 wins!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else if (hasMatch == 2 && !tie) {
                    System.out.println("Player 2 wins!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else if (hasMatch == 0 && !tie) {
                    if (order) {
                        order = false;
                    } else {
                        order = true;
                    }
                } else if (tie) {
                    System.out.println("Tie Game!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                }
            } else {
                System.out.println("It is the computer's turn.\n");

                symbol = "O";
                boolean confirming = true;
                while (confirming) {
                    int [] location = AI.getLocation(board, symbol);
                    row = location[0]; column = location[1];

                    if (board[row][column].equals("-")) {
                        board[row][column] = symbol;
                        confirming = false;
                    }
                }


                int hasMatch = Match.isMatching(board); // INT TO DETERMINE WINNER (0 = no match, 1 = P1 win, 2 = P2 win)
                boolean tie = Match.tieGame(board);

                if (hasMatch == 1 && !tie) {
                    System.out.println("You win!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else if (hasMatch == 2 && !tie) {
                    System.out.println("The computer wins!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                } else if (hasMatch == 0 && !tie) {
                    if (order) {
                        order = false;
                    } else {
                        order = true;
                    }
                } else if (tie) {
                    System.out.println("Tie Game!\n");

                    System.out.println(board[0][0] + " " + board[0][1] + " " + board[0][2]);
                    System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
                    System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");

                    looping = false;
                }
            }

        }
    }
}