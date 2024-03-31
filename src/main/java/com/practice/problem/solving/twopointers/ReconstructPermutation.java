package com.practice.problem.solving.twopointers;

public class ReconstructPermutation {

    public int[] diStringMatch(String s) {
        int size = s.length();
        int[] perm = new int[size+1];
        int left = 0;
        int right = size;

        for (int i = 0; i < size; i++) {
            if(s.charAt(i) == 'I'){
                perm[i] = left++;
            } else{
                perm[i] = right--;
            }
        }

        perm[size] = left;

        return perm;
    }

    public static void main(String[] args) {
        ReconstructPermutation solution = new ReconstructPermutation();
        String s = "IDID";
        int[] perm = solution.diStringMatch(s);
        for (int num : perm) {
            System.out.print(num + " ");
        }
        // Output: 0 4 1 3 2
    }
}
