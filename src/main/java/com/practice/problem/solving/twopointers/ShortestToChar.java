package com.practice.problem.solving.twopointers;

public class ShortestToChar {

    public int[] shortestToChar(String s, char c) {
        int size = s.length();
        int[] answer = new int[size];

        int left = -size;
        int right = 2*size;

        for (int i = 0; i < size; i++) {
            if(s.charAt(i) == c){
                left = i;
            }

            answer[i] = i - left;
        }

        for (int i = size - 1; i >=0 ; i--) {
            if(s.charAt(i) == c){
                right = i;
            }

            answer[i] = Math.min(answer[i], right - i);
        }

        return answer;
    }
}
