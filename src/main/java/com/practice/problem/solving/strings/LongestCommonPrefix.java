package com.practice.problem.solving.strings;

/**
 * Given an array of strings, return the longest common prefix that is shared amongst all strings.sss
 */
public class LongestCommonPrefix {

    public String commonPrefix(String[] inputArray, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int middleIndex = (startIndex + endIndex)/2;
            String inputStringOne = commonPrefix(inputArray,startIndex,middleIndex);
            String inputStringTwo = commonPrefix(inputArray,middleIndex+1,endIndex);
            return commonPrefixProcedure(inputStringOne,inputStringTwo);
        }

        return inputArray[startIndex];
    }

    public String commonPrefixProcedure(String inputStringOne, String inputStringTwo){
        int inputStringOneLength = inputStringOne.length();
        int inputStringTwoLength = inputStringTwo.length();

        StringBuilder outputString = new StringBuilder();
        for (int i = 0,j =0; i <= inputStringOneLength-1 && j<= inputStringTwoLength-1 ; i++,j++) {
            if(inputStringOne.charAt(i) != inputStringTwo.charAt(j)){
                break;
            }

            outputString.append(inputStringOne.charAt(i));
        }

        return outputString.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        String firstString = strs[0];
        String output = "";
        for(int i=0; i < firstString.length(); i++){
            for(int j = 1; j < strs.length; j++){
                if(strs[j].length() >= firstString.length() && firstString.charAt(i) == strs[j].charAt(i)){
                    output = output + firstString.charAt(i);
                }
            }
        }

        return output;
    }
}
