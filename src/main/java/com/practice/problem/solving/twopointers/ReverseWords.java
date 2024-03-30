package com.practice.problem.solving.twopointers;

public class ReverseWords {

    public String reverseWords(String s) {
        s = s.trim();

        StringBuilder stringBuilder = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0) {
            // Move end pointer to the end of a word
            while (end >= 0 && s.charAt(end) == ' ') {
                end--;
            }

            int start = end;
            // Move start pointer to the start of the word
            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }

            // Append word to the result string
            stringBuilder.append(s.substring(start + 1, end + 1));

            if (start >= 0) {
                // Append a single space if more words are remaining
                stringBuilder.append(' ');
            }

            // Move end pointer to the start of the next word
            end = start;
        }

        return stringBuilder.toString();
    }
}
