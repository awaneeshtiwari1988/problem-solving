package com.practice.problem.solving.twopointers;

public class ReverseSubString {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int start = 0;
        int end = 0;

        while (end < n) {
            if ((end + 1) % (2 * k) == 0) {
                reverse(chars, start, Math.min(start + k - 1, n - 1));
                start = end + 1;
            }
            end++;
        }

        // Reverse the remaining characters if there are fewer than k characters left
        if (start < n) {
            reverse(chars, start, Math.min(start + k - 1, n - 1));
        }

        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
