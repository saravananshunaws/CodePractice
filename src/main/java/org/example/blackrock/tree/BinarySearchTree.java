package org.example.blackrock.tree;

import java.util.*;
import java.math.*;
import java.io.*;

/*
       10
     /     \
     5      15
   /   \   /   \
  2     6 13   22
 /           \
 1            14

*/

public class BinarySearchTree {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void inorder(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }


    public static TreeNode insert(TreeNode root, int data) {
        if(root == null){
            return new TreeNode(data);
        }

        if(data < root.data){
            root.left = insert(root.left, data);
        }else if(data > root.data){
            root.right = insert(root.right, data);
        }
        return root;
    }

    public static TreeNode remove(TreeNode root, int data) {
        if(root == null){
            return null;
        }
        if(data < root.data ){
            root.left = remove(root.left, data);
        } else if(data > root.data){
            root.right = remove(root.right, data);
        } else{
            if (root.left == null && root.right == null){
                return null;
            } else if(root.left != null && root.right != null){
                 TreeNode node = root.right;
                 while(node.left != null){
                     node = node.left;
                 }

                 root.data = node.data;
                 root.right = remove(root.right, node.data);
                System.out.println(root);
            }
            else {
                TreeNode child = (root.left != null) ? root.left: root.right;
                root = child;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        insert(root, 5);
        insert(root, 15);
        insert(root, 2);
        insert(root, 6);
        insert(root, 13);
        insert(root, 22);
        insert(root, 1);
        insert(root, 14);
        insert(root, 16);

        System.out.println(root);
        inorder(root);
        System.out.println("\n");
        remove(root, 1);
        inorder(root);
    }
}
