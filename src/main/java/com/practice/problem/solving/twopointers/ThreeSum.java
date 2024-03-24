package com.practice.problem.solving.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * Algorithm: 1. Sort the array.
     * 2. Iterate through the elements upto n - 2 in parent loop.
     * 3. Check for duplicates at position i - 1 and i if i > 0.
     * 4. Set two variables acting as two pointers for start and end of array.
     * 5. Iterate the loop till startIndex and EndIndex converge on middle.
     * 6. In each loop, add the triplet of i, startIndex and endIndex.
     * 7. Check if the value is equal to target. If yes add them into the list.
     * 8. Check for duplicates and increase decrease respective pointers.
     * @return List<List<Integer>>
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int sum;
        for(int i=0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int startIndex = i+1;
            int endIndex = nums.length - 1;
            while (startIndex < endIndex){
                sum = nums[i] + nums[startIndex] + nums[endIndex];
                if(sum == 0){
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[startIndex]);
                    triplets.add(nums[endIndex]);
                    output.add(triplets);

                    while (startIndex < endIndex && nums[startIndex] == nums[startIndex + 1]){
                        startIndex++;
                    }

                    while (startIndex < endIndex && nums[endIndex] == nums[endIndex - 1]){
                        endIndex--;
                    }

                    startIndex++;
                    endIndex--;
                } else if (sum < 0){
                    startIndex++;
                } else {
                    endIndex--;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> output = threeSum.threeSum(new int[]{-1,0,1,2,-1,-4});
        for(List<Integer> lst : output){
            System.out.println(Arrays.toString(lst.toArray()));
        }
    }
}
