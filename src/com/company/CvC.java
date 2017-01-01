package com.company;

public class CvC {

    public static void beginGame (boolean order) {
        boolean looping = true;
        int row; int column;
        String symbol;

        String [][] board = {{"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"}};

        while (looping) {
            System.out.println("\n" + board[0][0] + " " + board[0][1] + " " + board[0][2]);
            System.out.println(board[1][0] + " " + board[1][1] + " " + board[1][2]);
            System.out.println(board[2][0] + " " + board[2][1] + " " + board[2][2] + "\n");
            if (order) {
                System.out.println("It is the computer's turn.\n");

                symbol = "X";
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
                System.out.println("It is the other computer's turn.\n");

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
            }

        }
    }
}
