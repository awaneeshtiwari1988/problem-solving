package com.practice.problem.solving.array;

public class MedianArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] outputArray = new int[nums1.length + nums2.length];
        int i=0,j = 0, k=0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                outputArray[k] = nums1[i];
                i++;
            } else {
                outputArray[k] = nums2[j];
                j++;
            }
            k++;
        }

        while(i < nums1.length){
            outputArray[k] = nums1[i];
            i++;
            k++;
        }

        while(j < nums2.length){
            outputArray[k] = nums2[j];
            j++;
            k++;
        }

        int length = outputArray.length;
        if(length % 2 != 0){
            return outputArray[(length)/2];
        } else {
            return Double.valueOf(outputArray[(length -1)/2] + outputArray[(length+1)/2])/2;
        }
    }

    public static void main(String[] args) {
        MedianArray medianArray = new MedianArray();
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(medianArray.findMedianSortedArrays(nums1,nums2));
    }
}
