package com.practice.problem.solving.twopointers;

public class MinimumAdjacentSwaps {

    public int getMinSwaps(String num, int k) {
        // Step 1: Convert to characters
        char[] digits = String.valueOf(num).toCharArray();

        // Step 2: Find i such that num[i] < num[i+1]
        for(int x = 0; x < k; x++) {
            int i = digits.length - 2;
            while (i >= 0 && digits[i] >= digits[i + 1]) {
                i--;
            }

            // Step 3: If no num is found then  number is already greatest return -1.
            if (i == -1) {
                return -1;
            }

            int j = digits.length - 1;
            while (j > i && digits[j] <= digits[i]) {
                j--;
            }

            swap(digits, i, j);
            reverse(digits, i + 1);
        }

        return countSwaps(num.toCharArray(), digits);
    }

    private int countSwaps(char[] original, char[] digits) {
        int swaps = 0;
        int i =0, j = 0;

        while(i < original.length){
            j = i;
            while (original[j] != digits[i]){
                j++;
            }

            while (i < j) {
                swap(original, j, j - 1);
                j--;
                swaps++;
            }
            i++;
        }

        return swaps;
    }

    private void reverse(char[] digits, int i) {
        int end = digits.length - 1;
        while (i < end){
            swap(digits, i, end);
            i++;
            end--;
        }
    }

    private void swap(char[] digits, int i, int j) {
        char ch = digits[i];
        digits[i] = digits[j];
        digits[j] = ch;
    }
}
