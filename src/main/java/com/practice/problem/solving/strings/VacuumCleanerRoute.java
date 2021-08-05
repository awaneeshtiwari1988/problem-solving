package com.practice.problem.solving.strings;

/**
 * Given a string representing the sequence of moves a robot vacuum makes,
 * return whether or not it will return to its original position.
 * The string will only contain L, R, U, and D characters, representing left,
 * right, up, and down respectively.
 */
public class VacuumCleanerRoute {

    public boolean isBackToOriginalPosition(String inputString){
        int finalPosition = 0;
        for (int i = 0; i < inputString.length(); i++) {
            finalPosition = finalPosition + getCoordinateValue(inputString.charAt(i));
        }

        return finalPosition == 0;
    }

    private int getCoordinateValue(char ch){
        switch (ch){
            case 'L':
            case 'D':
                return -1;
            case 'R':
            case 'U':
                return 1;
            default:
                break;
        }
        return 0;
    }
}
