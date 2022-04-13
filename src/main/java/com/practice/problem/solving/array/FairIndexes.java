package com.practice.problem.solving.array;

public class FairIndexes {
    public int getTotalFairIndexes(int[] A, int[] B) {
        if (A.length == 1 || B.length == 1){
            return 0;
        }

        int[] sumOfIndexesOfA = new int[A.length];
        int[] sumOfIndexesOfB = new int[B.length];
        int sumA = 0;
        int sumB = 0;

        // Populate Sum of A
        for(int i =0; i < A.length; i++){
            sumA = sumA + A[i];
            sumB = sumB + B[i];
            sumOfIndexesOfA[i] = sumA;
            sumOfIndexesOfB[i] = sumB;
        }

        // Initialize Counter
        int countFairIndexes = 0;

        // Compare the sums of each of the indexes
        for(int i =0; i < A.length; i++){
            if((sumOfIndexesOfA[i] == sumOfIndexesOfB[i])){
                countFairIndexes++;
            }
        }

        return countFairIndexes;
    }

    public static void main(String[] args) {
        FairIndexes fairIndexes = new FairIndexes();
        int[] A = {2,-2,-3,3};
        int[] B = {0,0,4,-4};
        System.out.println(fairIndexes.getTotalFairIndexes(A,B));
    }
}
