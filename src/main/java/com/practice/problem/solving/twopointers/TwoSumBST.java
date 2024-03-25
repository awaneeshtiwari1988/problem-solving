package com.practice.problem.solving.twopointers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumBST {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }

    private boolean dfs(TreeNode root, HashSet<Integer> set, int k) {
        if(root == null){
            return false;
        }

        if(set.contains(k - root.val)){
            return true;
        }

        set.add(root.val);
        return dfs(root.left, set, k) || dfs(root.right, set, k);
    }

    public boolean findTargetWithTwoPointers(TreeNode root, int k) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        int left = 0, right = inorderList.size() - 1;

        while (left < right){
            int sum = inorderList.get(left) + inorderList.get(right);
            if(sum == k){
                return true;
            } else if(sum < k){
                left++;
            } else {
                right--;
            }
        }

        return false;
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorderList) {
        if (root == null){
            return;
        }

        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }
}
