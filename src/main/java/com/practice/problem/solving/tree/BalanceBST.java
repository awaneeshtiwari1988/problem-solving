package com.practice.problem.solving.tree;

public class BalanceBST {

    AVLNode root;

    class AVLNode {
        int value;
        int height;
        AVLNode left;
        AVLNode right;

        public AVLNode(int value) {
            this.value = value;
            this.height = 1;
        }
    }

    public void insert(int key){
        root = insert(this.root, key);
    }

    private AVLNode insert(AVLNode root, int key) {
        // 1. Perform Insertion in BST
        if(root == null){
            return  new AVLNode(key);
        }

        // 2. If Node exists, perform BST Insertion
        if(key < root.value){
            root.left = insert(root.left,key);
        } else if(key > root.value){
            root.right = insert(root.right, key);
        } else {
            return root;
        }

        // 3. Update the height of the AVL tree
        root.height = 1 + (Math.max(height(root.left), height(root.right)));

        // 4. Get Balance Factor of the tree
        int balanceFactor = getBalance(root);

        // If the balance factor is imbalanced then following cases:

        //5. Left-Left case
        if(balanceFactor > 1 && key < root.left.value){
            return rotateRight(root);
        }

        //6. Left Right case
        if(balanceFactor > 1 && key > root.left.value){
            // rotate left & rotate right
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        //7. Right-Right case.
        if(balanceFactor < -1 && key > root.right.value){
            return rotateLeft(root);
        }

        //8. Right Left case
        if(balanceFactor < -1 && key < root.right.value){
            // rotate right & rotate left
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    private int getBalance(AVLNode root) {
        if(root == null){
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    private int height(AVLNode node) {
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private AVLNode rotateRight(AVLNode node){
        AVLNode rotatePointX = node.left;
        AVLNode rotatePointY = rotatePointX.right;

        rotatePointX.right = node;
        node.left = rotatePointY;

        // Update Heights
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        rotatePointX.height = Math.max(height(rotatePointX.left),height(rotatePointX.right)) + 1;

        return rotatePointX;
    }

    private AVLNode rotateLeft(AVLNode node){
        AVLNode rotatePointX = node.right;
        AVLNode rotatePointY = rotatePointX.left;

        rotatePointX.left = node;
        node.right = rotatePointY;

        // Update Heights
        node.height = Math.max(height(node.left),height(node.right)) + 1;
        rotatePointX.height = Math.max(height(rotatePointX.left),height(rotatePointX.right)) + 1;

        return rotatePointX;
    }

}
