package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Tic Tac O Jobs Know!\n");

        boolean yourTurn = true; boolean action = true;
        int mode = 0;

        while (action) {
            System.out.println("What mode would you like to play?");
            System.out.println("(1) Player vs Player\n(2) Player vs Computer");
            try {
                mode = sc.nextInt();
                if (mode == 1 || mode == 2) {
                    action = false;
                } else {
                    System.out.println("Number inputted is an invalid mode ID.");
                    System.out.println("Please input a valid mode ID.");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Your input was not a number.");
            }
        }

        if (mode == 2) {
            action = true;
        } else {
            yourTurn = true;
        }

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

        if (mode == 1) {
            PvP.beginGame(yourTurn);
        } else {
            PvC.beginGame(yourTurn);
        }
    }
}
