package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac Toe!\n");

        boolean yourTurn = true; boolean action = true;
        int mode = 0;

        while (action) {
            System.out.println("What mode would you like to play?");
            System.out.println("(1) Player vs Player\n(2) Player vs Computer\n(3) Computer vs Computer");
            try {
                mode = sc.nextInt();
                if (mode == 1 || mode == 2 || mode == 3) {
                    action = false;
                    sc.next();
                } else {
                    System.out.println("Number inputted is an invalid mode ID.");
                    System.out.println("Please input a valid mode ID.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Your input was not a number.");
                sc.next();
            }
        }

        if (mode == 2) {
            action = true;
        }

        Scanner sc2 = new Scanner(System.in);

        while (action) {
            System.out.println("Would you like to go first? Yes or No");
            String response = sc2.nextLine().toLowerCase();
            if (response.equals("yes")) {
                yourTurn = true; action = false;
            } else if (response.equals("no")) {
                yourTurn = false; action = false;
            } else {
                System.out.println("Please input a valid answer.");
            }
        }

        if (mode == 1) {
            System.out.println("There are 3 Rows and 3 Columns.");
            System.out.println("Rows 1-3 and Columns 1-3.");
            PvP.beginGame(true);
        } else if (mode == 2) {
            System.out.println("There are 3 Rows and 3 Columns.");
            System.out.println("Rows 1-3 and Columns 1-3.");
            PvC.beginGame(yourTurn);
        } else {
            System.out.println("There are 3 Rows and 3 Columns.");
            System.out.println("Rows 1-3 and Columns 1-3.");
            CvC.beginGame(true);
        }
    }
}


