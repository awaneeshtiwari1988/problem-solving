package com.practice.problem.solving.twopointers;

public class SentenceSimilarity {

    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        int len1 = words1.length, len2 = words2.length;

        int ptr1 = 0, ptr2 = 0;

        // Skip common prefix
        while (ptr1 < len1 && ptr2 < len2 && words1[ptr1].equals(words2[ptr2])) {
            ptr1++;
            ptr2++;
        }

        // Skip common suffix
        while (ptr1 < len1 && ptr2 < len2 && words1[len1 - 1].equals(words2[len2 - 1])) {
            len1--;
            len2--;
        }

        return ptr1 == len1 || ptr2 == len2;
    }
}
