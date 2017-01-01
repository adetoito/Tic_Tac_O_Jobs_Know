package com.company;

import java.util.*;

public class AI {

    // PRIMARY METHOD

    public static int [] getLocation (String [][] board, String symbol) {
        String otherSymbol;
        if (symbol.equals("X")) {
            otherSymbol = "O";
        } else {
            otherSymbol = "X";
        }

        int [][] allLocations = detectCombos(board, otherSymbol); // 0 = Row, 1 = Column, 2 = Point Value
        int [] location = prioritize(board, allLocations);

        int [] coords = new int [2];

        if (turn(board, symbol, otherSymbol) == 1) {
            coords[0] = firstTurnCoords()[0]; coords[1] = firstTurnCoords()[1];
        } else if (turn(board, symbol, otherSymbol) == 2) {
            coords[0] = secondTurnCoords(board, symbol, otherSymbol)[0]; coords[1] = secondTurnCoords(board, symbol, otherSymbol)[1];
        } else {
            coords[0] = location[0]; coords[1] = location[1];
        }

        return coords;
    }

    // SECONDARY METHODS

    public static int [][] detectCombos (String [][] board, String otherSymbol) {
        int [][] allLocations = new int [50][3];

        for (int i = 0; i < allLocations.length; i++) {
            for (int j = 0; j < allLocations[0].length; j++) {
                allLocations[i][j] = -1;
            }
        }

        int index = 0;

        if ((board[0][0].equals(otherSymbol) && board[2][2].equals(otherSymbol)) || (board[0][2].equals(otherSymbol) && board[2][0].equals(otherSymbol))) {
            if (board[1][1].equals("-")) {
                allLocations[index][0] = 1; allLocations[index][1] = 1; allLocations[index][2] = 3;
                index++;
            }
        }
        if (board[0][0].equals(otherSymbol) && board[1][1].equals(otherSymbol)) {
            if (board[2][2].equals("-")) {
                allLocations[index][0] = 2; allLocations[index][1] = 2; allLocations[index][2] = 3;
                index++;
            }
        }
        if (board[1][1].equals(otherSymbol) && board[2][2].equals(otherSymbol)) {
            if (board[0][0].equals("-")) {
                allLocations[index][0] = 0; allLocations[index][1] = 0; allLocations[index][2] = 3;
                index++;
            }
        }
        if (board[1][1].equals(otherSymbol) && board[2][0].equals(otherSymbol)) {
            if (board[0][2].equals("-")) {
                allLocations[index][0] = 0; allLocations[index][1] = 2; allLocations[index][2] = 3;
                index++;
            }
        }
        if (board[1][1].equals(otherSymbol) && board[0][2].equals(otherSymbol)) {
            if (board[2][0].equals("-")) {
                allLocations[index][0] = 2; allLocations[index][1] = 0; allLocations[index][2] = 3;
                index++;
            }
        }

        for (int i = 0; i < 2; i++) { // Row 2 ****
            if (board[0][i].equals(otherSymbol) && board[1][i].equals(otherSymbol)) {
                if (board[2][i].equals("-")) {
                    allLocations[index][0] = 2; allLocations[index][1] = i;  allLocations[index][2] = 1;
                    index++;
                }
            }
        }
        for (int i = 0; i < 2; i++) { // Row 1
            if (board[0][i].equals(otherSymbol) && board[2][i].equals(otherSymbol)) {
                if (board[1][i].equals("-")) {
                    allLocations[index][0] = 1; allLocations[index][1] = i; allLocations[index][2] = 2;
                    index++;
                }
            }
        }
        for (int i = 0; i < 2; i++) { // Row 0
            if (board[1][i].equals(otherSymbol) && board[2][i].equals(otherSymbol)) {
                if (board[0][i].equals("-")) {
                    allLocations[index][0] = 0; allLocations[index][1] = i; allLocations[index][2] = 2;
                    index++;
                }
            }
        }

        for (int i = 0; i < 2; i++) { // Column 2 ****
            if (board[i][0].equals(otherSymbol) && board[i][1].equals(otherSymbol)) {
                if (board[i][2].equals("-")) {
                    allLocations[index][0] = i; allLocations[index][1] = 2; allLocations[index][2] = 1;
                    index++;
                }
            }
        }
        for (int i = 0; i < 2; i++) { // Column 1
            if (board[i][0].equals(otherSymbol) && board[i][2].equals(otherSymbol)) {
                if (board[i][1].equals("-")) {
                    allLocations[index][0] = i; allLocations[index][1] = 1; allLocations[index][2] = 2;
                    index++;
                }
            }
        }
        for (int i = 0; i < 2; i++) { // Column 0
            if (board[i][1].equals(otherSymbol) && board[i][2].equals(otherSymbol)) {
                if (board[i][0].equals("-")) {
                    allLocations[index][0] = i; allLocations[index][1] = 0; allLocations[index][2] = 2;
                    index++;
                }
            }
        }
        return allLocations;
    }

    public static int [] prioritize (String [][] board, int [][] allLocations) {
        // Used mainly after multiple symbols have been placed down.

        int [] coords = new int [2];
        int i = 0; int pointValue = allLocations[i][2];
        coords[0] = allLocations[i][0]; coords[1] = allLocations[i][1];

        for (i = 1; i < allLocations.length; i++) {
            if (pointValue < allLocations[i][2]) {
                pointValue = allLocations[i][2];
                coords[0] = allLocations[i][0]; coords[1] = allLocations[i][1];
            }
            if (allLocations[i][0] == -1) {
                break;
            }
        }

        if (coords[0] == -1 && coords[1] == -1) {
            for (i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals("-")) {
                        coords[0] = i; coords[1] = j;
                    }
                }
            }
        }

        return coords;
    }

    public static int turn (String [][] board, String symbol, String otherSymbol) { // Determines what turn it is.
        int increment = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(otherSymbol) || board[i][j].equals(symbol)) {
                    increment++;
                }
            }
        }
        return (increment + 1);
    }

    public static int [] firstTurnCoords () {
        // Chooses from the corners or middle.

        Random rand = new Random();
        int value = rand.nextInt(5);
        int [] coords = new int [2];

        if (value == 0) {
            coords[0] = 0; coords[1] = 0;
        } else if (value == 1) {
            coords[0] = 0; coords[1] = 2;
        } else if (value == 2) {
            coords[0] = 1; coords[1] = 1;
        } else if (value == 3) {
            coords[0] = 2; coords[1] = 0;
        } else {
            coords[0] = 2; coords[1] = 2;
        }

        return coords;
    }

    public static int [] secondTurnCoords (String [][] board, String symbol, String otherSymbol) {
        // Deduces where to place symbol after one has been placed by the player.

        int [] coords = new int [2];
        int [] location = new int [2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals(otherSymbol) || board[i][j].equals(symbol)) {
                    location[0] = i; location[1] = j;
                }
            }
        }
        if ((location[0] == 0 && location[1] == 0) || (location[0] == 0 && location[1] == 2) || (location[0] == 2 && location[1] == 0) || (location[0] == 2 && location[1] == 2)) {
            coords[0] = 1; coords[1] = 1;
        } else if (location[0] == 1 && location[1] == 1) {
            Random rand = new Random();
            int value = rand.nextInt(4);
            if (value == 0) {
                coords[0] = 0; coords[1] = 0;
            } else if (value == 1) {
                coords[0] = 0; coords[1] = 2;
            } else if (value == 2) {
                coords[0] = 2; coords[1] = 0;
            } else {
                coords[0] = 2; coords[1] = 2;
            }
        }
        return coords;
    }
}