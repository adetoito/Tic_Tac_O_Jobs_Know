package com.company;

import java.util.*;

public class AI {

    public static int makeDecision (String [] a) {
        Random rand = new Random();
        int [] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1};

        for (int i = 0; i < a.length; i++) {
            if (a[i].equals("X")) {
                b[i] = i + 1;
            }
        }

        int location = 1;
        boolean action = true;
        while (action) {
            location = b[rand.nextInt(a.length)];
            if (location != -1) {
                action = false;
            }
        }
        return location;
    }
}
