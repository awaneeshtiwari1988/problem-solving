package com.practice.problem.solving.twopointers;

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        int left = 0;
        int right = 0;

        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == ch){
                right = i;
                break;
            }
        }

        if(right < word.length()){
            word = reversedWordPrefix(word, left, right);
        }

        return word;
    }

    private String reversedWordPrefix(String word, int left, int right) {
        char[] chars = word.toCharArray();
        while(left <  right){
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(chars);
    }
}
