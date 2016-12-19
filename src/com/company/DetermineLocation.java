package com.company;

public class DetermineLocation {

    /*
    This class is used mainly for organization.
     */

    public static int findLocation (int c) {
        int location;
        if (c == 1) {
            location = 0;
        } else if (c == 2) {
            location = 1;
        } else {
            location = 2;
        }
        return location;
    }

}
