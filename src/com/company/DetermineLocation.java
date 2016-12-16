package com.company;

public class DetermineLocation {

    public DetermineLocation () {}

    public int findLocation (int r, int c) {
        int location;
        if (r == 1) {
            if (c == 1) {
                location = 1;
            } else if (c == 2) {
                location = 2;
            } else {
                location = 3;
            }
        } else if (r == 2) {
            if (c == 1) {
                location = 4;
            } else if (c == 2) {
                location = 5;
            } else {
                location = 6;
            }
        } else {
            if (c == 1) {
                location = 7;
            } else if (c == 2) {
                location = 8;
            } else {
                location = 9;
            }
        }
        return location;
    }

}
