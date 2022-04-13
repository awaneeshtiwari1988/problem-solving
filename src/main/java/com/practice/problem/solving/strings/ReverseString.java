package com.practice.problem.solving.strings;

import java.util.Stack;

/**
 * Given a string, reverse all of its characters and return the resulting string.
 */
public class ReverseString {
    public String reverseStringByStringBuilder(String inputString){
        StringBuilder stringBuilder = new StringBuilder(inputString);
        return stringBuilder.reverse().toString();
    }

    public String reverseStringByTraversingChars(String inputString){
        String reverseString = "";
        for (int i = inputString.length() - 1; i >= 0; i--) {
            reverseString = reverseString.concat(String.valueOf(inputString.charAt(i)));
        }

        return reverseString;
    }

    public char[] reverseStringByTwoWayTraversal(char[] inputString){
        int startIndex = 0;
        int endIndex = inputString.length - 1;
        while (startIndex < endIndex){
            char temp = inputString[startIndex];
            inputString[startIndex] = inputString[endIndex];
            inputString[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return inputString;
    }

    public char[] reverseStringByStacks(char[] inputString){
        Stack<Character> characterStack = new Stack<>();
        for (char ch : inputString) {
            characterStack.push(ch);
        }

        char[] outputString = new char[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            outputString[i] = characterStack.pop();
        }

        return outputString;
    }

    public String reverseStr(String inputString, int k) {
        char[] inputChar = inputString.toCharArray();
        for (int i = 0; i < inputChar.length - 1; i = i+2*k) {
                int startIndex = i;
                int endIndex = Math.min(i + k - 1, inputChar.length - 1);
                while(startIndex < endIndex){
                    char temp = inputChar[startIndex];
                    inputChar[startIndex] = inputChar[endIndex];
                    inputChar[endIndex] = temp;
                    startIndex++;
                    endIndex--;
            }
        }

        return String.valueOf(inputChar);
    }

    public String reverseWords(String s) {
        String[] inputStringArray = s.trim().split(" ");
        Stack<String> stack = new Stack<>();
        for(String input : inputStringArray){
            input = input.trim();
            if(!input.equals("")) {
                stack.push(input);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseWords("a good   example"));
    }

}
