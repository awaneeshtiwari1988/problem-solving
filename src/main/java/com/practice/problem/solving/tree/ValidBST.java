package com.practice.problem.solving.tree;

public class ValidBST {
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }


    public boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer minValue, Integer maxValue) {
        if(root == null){
            return true;
        }

        if(minValue != null && minValue >= root.value){
            return false;
        }

        if(maxValue != null && root.value >= maxValue){
            return false;
        }

        return  isValidBST(root.left, minValue, root.value)
                && isValidBST(root.right, root.value, maxValue);
    }

}
