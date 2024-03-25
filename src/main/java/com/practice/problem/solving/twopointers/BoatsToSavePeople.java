package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {

        // Step 1: Sort the given array
        Arrays.sort(people);

        // Step 2: Initialize left and right pointers
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right){
            if(people[left] + people[right] <= limit){
                left++;
                right--;
            } else if(people[left] + people[right] > limit){
                right--;
            }

            boats++;
        }

        return boats;
    }
}
