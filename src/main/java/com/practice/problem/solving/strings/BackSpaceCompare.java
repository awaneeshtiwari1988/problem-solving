package com.practice.problem.solving.strings;

public class BackSpaceCompare {

    public boolean backspaceCompare(String s, String t) {
        if(s.equals("") && t.equals("")){
            return true;
        }

        String backSpaceString1 = "";
        char[] inputStringArray = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = inputStringArray[i];
            if(c != '#'){
                backSpaceString1 = backSpaceString1 + String.valueOf(c);
            } else {
                if(backSpaceString1.length() > 0) {
                    backSpaceString1 = backSpaceString1.substring(0, backSpaceString1.length() - 1);
                }
            }
        }

        String backSpaceString2 = "";
        char[] inputStringArray2 = t.toCharArray();
        for(int i = 0; i < t.length(); i++){
            char c = inputStringArray2[i];
            if(c != '#'){
                backSpaceString2 = backSpaceString2 + String.valueOf(c);
            } else {
                if(backSpaceString2.length() > 0){
                    backSpaceString2 = backSpaceString2.substring(0, backSpaceString2.length() - 1);
                }
            }
        }

        if(backSpaceString1.equals(backSpaceString2)){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        BackSpaceCompare backSpaceCompare = new BackSpaceCompare();
        System.out.println(backSpaceCompare.backspaceCompare("a#c","b"));
    }
}
