package com.practice.problem.solving.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        preOrderTraversalRecursive(root, result);
        return result;
    }

    private void preOrderTraversalRecursive(TreeNode root, List<Integer> result){
        result.add(root.val);

        if(root.left != null){
            preOrderTraversalRecursive(root.left, result);
        }

        if(root.right != null){
            preOrderTraversalRecursive(root.right, result);
        }
    }

    private List<Integer> preOrderTraversalIterative(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            result.add(currentNode.val);

            if(currentNode.right != null){
                stack.push(currentNode.right);
            }

            if(currentNode.left != null){
                stack.push(currentNode.left);
            }
        }

        return result;
    }
}
