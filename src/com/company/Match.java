package com.company;

public class Match {

    public static int isMatching (String [][] board) {
        /*
        REFERENCE:

        R1: 1 2 3
        R2: 1 2 3
        R3: 1 2 3

        COMBOS:
        R1[1/2/3], R2[1/2/3], R3[1/2/3] //COMBO 1
        R1/2/3[1], R1/2/3[2], R1/2/3[3] //COMBO 2
        R1[1], R2[2], R3[3] //COMBO 3
        R1[3], R2[2], R3[1] //COMBO 4
         */
        int match = 0;

        for (int i = 0; i <= 2; i++) { //1
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i])) {
                if (board[0][i].equals("X")) {
                    match = 1;
                } else if (board[0][i].equals("O")) {
                    match = 2;
                }
                break;
            }
        }
        if (match == 0) { //2
            if (board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2])) {
                if (board[0][0].equals("X")) {
                    match = 1;
                } else if (board[0][0].equals("O")) {
                    match = 2;
                }
            }
            if (board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2])) {
                if (board[1][0].equals("X")) {
                    match = 1;
                } else if (board[1][0].equals("O")) {
                    match = 2;
                }
            }
            if (board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2])) {
                if (board[2][0].equals("X")) {
                    match = 1;
                } else if (board[2][0].equals("O")) {
                    match = 2;
                }
            }
        }

        if (match == 0) { //3
            if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2])) {
                if (board[0][0].equals("X")) {
                    match = 1;
                } else if (board[0][0].equals("O")) {
                    match = 2;
                }
            }
        }

        if (match == 0) { //4
            if (board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2])) {
                if (board[2][0].equals("X")) {
                    match = 1;
                } else if (board[2][0].equals("O")) {
                    match = 2;
                }
            }
        }
        return match;
    }

}
