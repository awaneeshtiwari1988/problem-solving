package com.practice.problem.solving.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root){
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        TreeNode currentNode = root;
        queue.add(currentNode);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i =0; i < size; i++){
                currentNode = queue.poll();
                levelNodes.add(currentNode.val);

                if(currentNode.left != null){
                    queue.add(currentNode.left);
                }

                if(currentNode.right != null){
                    queue.add(currentNode.right);
                }
            }

            result.add(levelNodes);
        }

        return result;
    }
}
