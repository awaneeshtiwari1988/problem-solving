package com.practice.problem.solving.strings;

import java.util.regex.Pattern;

/**
 * Given a string, return whether or not it uses capitalization correctly.
 * A string correctly uses capitalization if all letters are capitalized,
 * no letters are capitalized, or only the first letter is capitalized.
 */
public class CorrectCapitalization {

    public boolean isCorrectCapitalization(String inputString){
        Pattern capitalPattern = Pattern.compile("^[A-Z]*");
        Pattern smallPattern = Pattern.compile("^[a-z]*");
        String firstChar = String.valueOf(inputString.charAt(0));

        if(capitalPattern.matcher(firstChar).matches()){
            if(smallPattern.matcher(inputString.substring(1)).matches()){
                return true;
            } else
                return capitalPattern.matcher(inputString.substring(1)).matches();
        } else {
            return smallPattern.matcher(inputString.substring(1)).matches();
        }
    }
}
