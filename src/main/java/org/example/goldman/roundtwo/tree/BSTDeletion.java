package org.example.goldman.roundtwo.tree;

public class BSTDeletion {
    static class Node
    {
        int data;
        Node left = null, right = null;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to perform inorder traversal on the BST
    public static void inorder(Node root)
    {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static Node insert(Node root, int key)
    {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    public static Node deleteNode(Node root, int key){
        if(root == null){
            return null;
        }
        if(root.data < key){
            root.left = deleteNode(root.left, key);
        }else if(root.data > key){
            root.right = deleteNode(root.right, key);
        }else{
              if(root.left == null && root.right == null){
                  return null;
              } else if(root.left != null && root.right != null){
                  Node node = root.right;
                  while(node.left != null){
                      node = node.left;
                  }
                  root.data = node.data;
                  root.right = deleteNode(root.right, node.data);
              }else {
                  // choose a child node
                  Node child = (root.left != null) ? root.left: root.right;
                  root = child;
              }
        }
        return root;
    }

    public static void main(String[] args)
    {
        int[] keys = { 15, 10, 20, 8, 12, 16 };

        Node root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        root = deleteNode(root, 16);
        inorder(root);
    }

}
