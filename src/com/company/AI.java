package com.company;

public class AI {

    // PRIMARY METHOD

    public static int [] getLocation (String [][] board) {
        int [][] allLocations = AI.detectCombos(board);
        int [] location = AI.prioritize(board, allLocations);
        int [] coords = {location[0], location[1]};
        return coords;
    }

    // SECONDARY METHODS

    public static int [][] detectCombos (String [][] board) {
        int [][] allLocations = new int [50][2];

        for (int i = 0; i < allLocations.length; i++) {
            for (int j = 0; j < allLocations[0].length; j++) {
                allLocations[i][j] = -1;
            }
        }

        int index = 0;

        if ((board[0][0].equals("X") && board[2][2].equals("X")) || (board[0][2].equals("X") && board[2][0].equals("X"))) {
            allLocations[index][0] = 1; allLocations[index][1] = 1;
            index++;
        }
        if (board[0][0].equals("X") && board[1][1].equals("X")) {
            allLocations[index][0] = 2; allLocations[index][1] = 2;
            index++;
        }
        if (board[1][1].equals("X") && board[2][2].equals("X")) {
            allLocations[index][0] = 0; allLocations[index][1] = 0;
            index++;
        }
        if (board[1][1].equals("X") && board[2][0].equals("X")) {
            allLocations[index][0] = 0; allLocations[index][1] = 2;
            index++;
        }
        if (board[1][1].equals("X") && board[0][2].equals("X")) {
            allLocations[index][0] = 2; allLocations[index][1] = 0;
            index++;
        }

        for (int i = 0; i < 2; i++) { // Row 2
            if (board[0][i].equals("X") && board[1][i].equals("X")) {
                allLocations[index][0] = 2; allLocations[index][1] = i;
                index++;
            }
        }
        for (int i = 0; i < 2; i++) { // Row 1
            if (board[0][i].equals("X") && board[2][i].equals("X")) {
                allLocations[index][0] = 1; allLocations[index][1] = i;
                index++;
            }
        }
        for (int i = 0; i < 2; i++) { // Row 0
            if (board[1][i].equals("X") && board[2][i].equals("X")) {
                allLocations[index][0] = 0; allLocations[index][1] = i;
                index++;
            }
        }

        for (int i = 0; i < 2; i++) { // Column 2
            if (board[i][0].equals("X") && board[i][1].equals("X")) {
                allLocations[index][0] = i; allLocations[index][1] = 2;
                index++;
            }
        }
        for (int i = 0; i < 2; i++) { // Column 1
            if (board[i][0].equals("X") && board[i][2].equals("X")) {
                allLocations[index][0] = i; allLocations[index][1] = 1;
                index++;
            }
        }
        for (int i = 0; i < 2; i++) { // Column 0
            if (board[i][1].equals("X") && board[i][2].equals("X")) {
                allLocations[index][0] = i; allLocations[index][1] = 0;
                index++;
            }
        }
        return allLocations;
    }

    public static int [] prioritize (String [][] board, int [][] allLocations) {
        int [] location = new int [2];
        return location;
    }
}
