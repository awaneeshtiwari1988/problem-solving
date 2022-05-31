package com.practice.problem.solving.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountTriplets {

    public int countTriplet(int arr[], int n) {
        Set<Integer> set = new HashSet<>();
        int tripletCount = 0;
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }

        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(set.contains(arr[i] + arr[j])){
                    tripletCount++;
                }
            }
        }

        return tripletCount;
    }

    public static void main(String[] args) {
        CountTriplets countTriplets = new CountTriplets();
        int[] inputArray = {12,8,2,11,5,14,10};
        System.out.println(countTriplets.countTriplet(inputArray,7));
    }
}
