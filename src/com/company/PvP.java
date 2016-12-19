package com.company;

import java.util.*;

public class PvP {

    public static void beginGame (boolean order) {
        Scanner sc = new Scanner(System.in);
        boolean looping = true;
        int row = 1; int column = 1;
        String symbol;

        String [] row1 = {"-", "-", "-"}; String [] row2 = {"-", "-", "-"}; String [] row3 = {"-", "-", "-"};

        while (looping) {
            if (order) {
                symbol = "X";
            } else {
                symbol = "O";
            }

            System.out.println(row1[0] + " " + row1[1] + " " + row1[2]);
            System.out.println(row2[0] + " " + row2[1] + " " + row2[2]);
            System.out.println(row3[0] + " " + row3[1] + " " + row3[2] + "\n");

            boolean action = true;
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

            if (row == 1) {
                row1[DetermineLocation.findLocation(column)] = symbol;
            } else if (row == 2) {
                row2[DetermineLocation.findLocation(column)] = symbol;
            } else {
                row3[DetermineLocation.findLocation(column)] = symbol;
            }

            int hasMatch = Match.isMatching(row1, row2, row3); // INT TO DETERMINE WINNER (0 = no match, 1 = P1 win, 2 = P2 win)

            if (hasMatch == 1) {
                System.out.println("Player 1 wins!");
                looping = false;
            } else if (hasMatch == 2) {
                System.out.println("Player 2 wins!");
                looping = false;
            } else {
                if (order) {
                    order = false;
                } else {
                    order = true;
                }
            }
        }
    }
}
