package com.company;

public class Match {

    public static int isMatching (String [] row1, String [] row2, String [] row3) {
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
            if (row1[i].equals(row2[i]) && row2[i].equals(row3[i])) {
                if (row1[i].equals("X")) {
                    match = 1;
                } else if (row1[i].equals("O")) {
                    match = 2;
                }
                break;
            }
        }
        if (match == 0) { //2
            if (row1[0].equals(row1[1]) && row1[1].equals(row1[2])) {
                if (row1[0].equals("X")) {
                    match = 1;
                } else if (row1[0].equals("O")) {
                    match = 2;
                }
            }
            if (row2[0].equals(row2[1]) && row2[1].equals(row2[2])) {
                if (row2[0].equals("X")) {
                    match = 1;
                } else if (row2[0].equals("O")) {
                    match = 2;
                }
            }
            if (row3[0].equals(row3[1]) && row3[1].equals(row3[2])) {
                if (row3[0].equals("X")) {
                    match = 1;
                } else if (row3[0].equals("O")) {
                    match = 2;
                }
            }
        }

        if (match == 0) { //3
            if (row1[0].equals(row2[1]) && row2[1].equals(row3[2])) {
                if (row1[0].equals("X")) {
                    match = 1;
                } else if (row1[0].equals("O")) {
                    match = 2;
                }
            }
        }

        if (match == 0) { //4
            if (row3[0].equals(row2[1]) && row2[1].equals(row1[2])) {
                if (row3[0].equals("X")) {
                    match = 1;
                } else if (row3[0].equals("O")) {
                    match = 2;
                }
            }
        }
        return match;
    }

}
