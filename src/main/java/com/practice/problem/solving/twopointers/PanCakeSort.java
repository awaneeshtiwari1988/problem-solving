package com.practice.problem.solving.twopointers;

import java.util.ArrayList;
import java.util.List;

public class PanCakeSort {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> flips = new ArrayList<>();
        int size = arr.length;

        for (int end = size - 1; end > 0; end--) {
            int maxIndex = findMaxIndex(arr, end);
            if(maxIndex != end){
                if(maxIndex != 0) {
                    flip(arr, maxIndex + 1);
                    flips.add(maxIndex + 1);
                }
                flip(arr,end+1);
                flips.add(end+1);
            }
        }

        return flips;
    }

    private void flip(int[] arr, int i) {
        int left = 0;
        int right = i - 1;
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private int findMaxIndex(int[] arr, int end) {
        int maxIndex = 0;
        for (int i = 1; i <= end; i++) {
            if(arr[i] > arr[maxIndex]){
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
