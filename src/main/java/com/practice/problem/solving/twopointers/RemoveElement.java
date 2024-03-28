package com.practice.problem.solving.twopointers;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;

        while (right < nums.length){
            if(nums[right] == val){
                right++;
            } else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
        System.out.println(length);

    }
}
