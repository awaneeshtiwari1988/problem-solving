package com.practice.problem.solving.array;

public class KLargestElementBySelectionSort {

    public int[] getKLargestElements(int[] originalArray, int numberOfLargestElements){
        int[] output = new int[numberOfLargestElements];
        originalArray = sortElementsBySelection(originalArray);
        for (int i = originalArray.length -1, j =0; i > numberOfLargestElements && j < numberOfLargestElements ; i--,j++) {
            output[j] = originalArray[i];
        }

        return output;
    }

    public int[] sortElementsBySelection(int[] originalArray){
        if(originalArray.length == 0){
            return originalArray;
        }

        int min, temp;
        for(int i=0; i < originalArray.length - 1;i++){
            min = i;
            for (int j = i+1; j < originalArray.length; j++) {
                if(originalArray[j] < originalArray[min]){
                    min = j;
                }
            }
            temp = originalArray[i];
            originalArray[i] = originalArray[min];
            originalArray[min] = temp;
        }

        return originalArray;
    }
}
