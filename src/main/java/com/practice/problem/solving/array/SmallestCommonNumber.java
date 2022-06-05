package com.practice.problem.solving.array;

public class SmallestCommonNumber {

    public int getSmallestCommonNumber(int[] inputArray1, int[] inputArray2, int[] inputArray3){
        int i=0, j =0, k =0;

        while(i < inputArray1.length && j < inputArray2.length && k < inputArray3.length){
            if(inputArray1[i] == inputArray2[j] && inputArray2[j] == inputArray3[k]){
                return inputArray1[i];
            }

            if(inputArray1[i] <= inputArray2[j] && inputArray1[i] <= inputArray3[k]){
                i++;
            } else if(inputArray2[j] <= inputArray3[k] && inputArray2[j] <= inputArray1[i]){
                j++;
            } else if(inputArray3[k] <= inputArray1[i] && inputArray3[k] <= inputArray2[j]){
                k++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SmallestCommonNumber smallestCommonNumber = new SmallestCommonNumber();
        int[] inputArray1 = {6, 7, 10, 25, 30, 63, 64};
        int[] inputArray2 = {0, 4, 5, 6, 7, 8, 50};
        int[] inputArray3 = {1, 6, 10, 14};

        System.out.println(smallestCommonNumber.getSmallestCommonNumber(inputArray1, inputArray2, inputArray3));
    }
}
