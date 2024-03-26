package com.practice.problem.solving.twopointers;

import java.util.Arrays;

public class ThreeSumWithMultiplicity {

    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        Arrays.sort(arr); // Step 1
        int count = 0; // Step 2
        int n = arr.length;

        // Step 3
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) { // Step 3.1
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) { // Step 3.2
                    if (arr[left] == arr[right]) {
                        int total = right - left + 1;
                        count = (count + (total * (total - 1)) / 2) % MOD;
                        break;
                    }

                    int leftCount = 1;
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftCount++;
                        left++;
                    }

                    int rightCount = 1;
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        rightCount++;
                        right--;
                    }

                    if (left == right) {
                        count += (leftCount * (leftCount - 1)) / 2;
                    } else {
                        count += leftCount * rightCount;
                    }

                    count %= MOD;
                    left++;
                    right--;
                } else if (sum < target) { // Step 3.3
                    left++;
                } else { // Step 3.4
                    right--;
                }
            }
        }

        return count; // Step 4
    }

    public static void main(String[] args) {
        ThreeSumWithMultiplicity solution = new ThreeSumWithMultiplicity();

        // Example 1
        int[] arr1 = {1, 1, 2, 2, 3, 3, 4, 4, 5, 5};
        int target1 = 8;
        System.out.println(solution.threeSumMulti(arr1, target1)); // Output: 20

        // Example 2
        int[] arr2 = {1, 1, 2, 2, 2, 2};
        int target2 = 5;
        System.out.println(solution.threeSumMulti(arr2, target2)); // Output: 12

        // Example 3
        int[] arr3 = {2, 1, 3};
        int target3 = 6;
        System.out.println(solution.threeSumMulti(arr3, target3)); // Output: 1
    }
}
