package com.practice.problem.solving.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
       if (s.length() == 0){
           return 0;
       }

       if(s.length() == 1){
           return 1;
       }

       int lenghtOfLongestSubString = 0;
       String output = "";
       for(char c : s.toCharArray()){
           String st = String.valueOf(c);
           if(output.contains(st)){
               output = output.substring(output.indexOf(st)+1);
           }

           output = output + st;
           lenghtOfLongestSubString = Math.max(lenghtOfLongestSubString,output.length());
       }

       return lenghtOfLongestSubString;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
        System.out.println(longestSubstring.lengthOfLongestSubstring(" "));
    }
}
