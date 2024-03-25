package com.practice.problem.solving.twopointers;

public class SumOfSquares {
    /**
     * Given a non-negative integer c, decide whether there're two integers a and b such that a2 + b2 = c.
     *
     *
     *
     * Example 1:
     *
     * Input: c = 5
     * Output: true
     * Explanation: 1 * 1 + 2 * 2 = 5
     * Example 2:
     *
     * Input: c = 3
     * Output: false
     *
     *
     * Constraints:
     *
     * 0 <= c <= 231 - 1
     */
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left<= right){
            double sum = Math.pow(left,2) + Math.pow(right,2);
            if(sum == c){
                return true;
            } else if (sum < c){
                left++;
            } else {
                right--;
            }
        }

        return false;
    }
}
