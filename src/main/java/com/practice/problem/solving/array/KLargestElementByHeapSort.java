package com.practice.problem.solving.array;

public class KLargestElementByHeapSort {

    public int[] getKLargestElements(int[] originalArray, int numberOfLargestElements){
        int[] output = new int[numberOfLargestElements];
        originalArray = sortElementsByHeapSort(originalArray);
        for (int i = originalArray.length -1, j =0; j < numberOfLargestElements ; i--,j++) {
            output[j] = originalArray[i];
        }

        return output;
    }

    public int[] sortElementsByHeapSort(int[] originalArray){
        buildMaxHeap(originalArray);
        for (int i = originalArray.length -1; i > 0; i--) {
            int temp = originalArray[0];
            originalArray[0] = originalArray[i];
            originalArray[i] = temp;
            maxHeap(originalArray,i,0);
        }

        return originalArray;
    }

    public void buildMaxHeap(int[] originalArray){
        for (int i = (originalArray.length)/2 - 1; i >= 0; i--) {
            maxHeap(originalArray,originalArray.length,i);
        }
    }

    public void maxHeap(int[] originalArray, int length, int index){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int largest = index;

        if(left <= length-1 && originalArray[left] > originalArray[largest] ){
            largest = left;
        }

        if(right <= length-1 && originalArray[right] > originalArray[largest] ){
            largest = right;
        }

        if(largest != index){
            int temp = originalArray[index];
            originalArray[index] = originalArray[largest];
            originalArray[largest] = temp;
            maxHeap(originalArray, length,largest);
        }
    }
}
