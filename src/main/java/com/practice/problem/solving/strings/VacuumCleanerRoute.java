package com.practice.problem.solving.strings;

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
