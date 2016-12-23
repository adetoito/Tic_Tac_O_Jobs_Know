package com.company;

import java.util.*;

public class PlayAgain {

    public static void askPvP () {

        // Although redundant, it helps connect all of the branching when there is a tie, or if Player 1 wins, etc.

        Scanner sc = new Scanner(System.in);
        boolean action = true;
        while (action) {
            System.out.println("Would you like to play again? Yes or No?");
            String response = sc.nextLine().toLowerCase();
            if (response.equals("yes")) {
                PvP.beginGame(true);
                action = false;
            } else if (!response.equals("yes") || !response.equals("no")) {
                System.out.println("Invalid answer. Type in Yes or No.");
            }
        }
    }

}
