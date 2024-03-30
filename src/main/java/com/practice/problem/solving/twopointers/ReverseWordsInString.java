package com.practice.problem.solving.twopointers;

public class ReverseWordsInString {

    public String reverseWords(String s) {
        String[] splitString = s.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : splitString) {
            if(!stringBuilder.isEmpty()){
                stringBuilder.append(" ");
            }
            int left = 0;
            int right = str.length() - 1;
            char[] chars = str.toCharArray();
            while (left < right){
                char ch = chars[left];
                chars[left] = chars[right];
                chars[right] = ch;
                left++;
                right--;
            }

            stringBuilder.append(chars);
        }

        return stringBuilder.toString();
    }
}
