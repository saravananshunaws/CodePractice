package org.example.ds.tree.thurs28;

import org.example.ds.tree.TreeNode;

import java.util.Stack;

public class TreeTraversal {

    public static void preOrderIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderIterative(root.left);
        preOrderIterative(root.right);
    }

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<TreeNode> out = new Stack<>();
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            out.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while(!out.empty()){
            System.out.print(out.pop().val + " ");
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        preOrder(root);
        System.out.println();
        preOrderIterative(root);
        System.out.println();
        inOrder(root);
        System.out.println("\nPost Order:: ");
        postOrder(root);

    }
}
