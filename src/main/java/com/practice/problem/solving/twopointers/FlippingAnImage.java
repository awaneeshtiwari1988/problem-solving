package com.practice.problem.solving.twopointers;

public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = image[i];
            int[] reversedRow = new int[n];
            for (int j = 0; j < n; j++) {
                reversedRow[j] = row[n - j - 1]; // Reverse the row
            }
            for (int j = 0; j < n; j++) {
                result[i][j] = (reversedRow[j] == 0) ? 1 : 0; // Invert the elements
            }
        }

        return result;
    }
}
