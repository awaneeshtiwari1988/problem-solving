package com.practice.problem.solving.array;

import java.util.Arrays;

public class AverageOfContiguousSubarrays {

    public double[] getAverageOfContiguousSubArrays(int[] nums, int k){
        int startIndex = 0;
        double sumOfContiguousElements = 0;
        double[] outputArray = new double[nums.length - k +1];
        for(int i =0; i < nums.length;i++){
            sumOfContiguousElements += nums[i];
            if(i >= k -1){
                outputArray[startIndex] = sumOfContiguousElements/k;
                sumOfContiguousElements -= nums[startIndex];
                startIndex++;
            }
        }

        return outputArray;
    }

    public static void main(String[] args) {
        AverageOfContiguousSubarrays averageOfContiguousSubArrays = new AverageOfContiguousSubarrays();
        int[] inputArray = {1,3,2,6,-1,4,1,8,2};
        System.out.println(Arrays.toString(averageOfContiguousSubArrays.getAverageOfContiguousSubArrays(inputArray,5)));
    }
}
