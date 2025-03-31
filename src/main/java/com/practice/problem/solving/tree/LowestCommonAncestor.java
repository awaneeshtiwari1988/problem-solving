package com.practice.problem.solving.tree;

public class LowestCommonAncestor {

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

       while(root != null){
           if(p.value < root.value && q.value < root.value){
                root = root.left;
           } else if(p.value > root.value && q.value > root.value){
               root = root.right;
           } else {
               return root;
           }
       }

        return null;
    }
}
