package org.example.goldman.roundone.tree;

public class BinarySearchTree {

    static class Node {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Recursive function to insert a key into a BST
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.data) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Function to perform inorder traversal on the BST
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node findMaximumKey(Node ptr) {
        while (ptr.right != null) {
            ptr = ptr.right;
        }
        return ptr;
    }

    public static Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        }
        else {
             if(root.left == null) return root.right;
             else if(root.right == null) return root.left;
             else{
                 Node succ = root.right;
                 while(succ != null && succ.left != null){
                     succ = succ.left;
                 }

                 root.data = succ.data;
                 root.right = deleteNode(root.right, succ.data);
             }
        }
        return root;
    }

    public static void main(String[] args) {
        int[] keys = {15, 10, 20, 8, 12, 16};

        Node root = null;
        for (int key : keys) {
            root = insert(root, key);
        }
        System.out.println("Delete Node:: ");
        deleteNode(root, 10);

        System.out.println("Inorder:: ");
        inorder(root);
    }

}
