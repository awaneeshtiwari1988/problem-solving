package com.practice.problem.solving.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {

    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }

    public ArrayList<Integer> leftView(Node root){

        if(root == null){
            return new ArrayList<>();
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        ArrayList<Integer> leftViewList = new ArrayList<>();
        while(!queue.isEmpty()){
            int n = queue.size();

            for(int i = 1; i <= n; i++){
                Node temp = queue.poll();

                if(i == 1){
                    assert temp != null;
                    leftViewList.add(temp.data);
                }

                assert temp != null;
                if(temp.left != null){
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    queue.add(temp.right);
                }
            }
        }
        return leftViewList;
    }

    public static void main(String[] args) {
        LeftViewTree leftViewTree = new LeftViewTree();
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        ArrayList<Integer> list = leftViewTree.leftView(root);
        list.forEach(System.out::println);
    }
}
