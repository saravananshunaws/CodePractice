package org.example.ds.tree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PreOrderTraversal {

    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
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

    public static void InOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode currNode = root;
        while (currNode != null && !stack.empty()) {
            while ((currNode.left != null)) {
                stack.push(currNode.left);
                currNode = currNode.left;
            }

            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            if (node.right != null) {
                stack.push(node.right);
                currNode = node.right;
            }
        }
    }

    public static void PostOrder(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            TreeNode node = stack1.pop();
            stack2.push(node);

            if(node.left != null){
                stack1.push(node.left);
            }

            if(node.right != null){
                stack1.push(node.right);
            }
        }

        stack2.forEach(node -> System.out.print(node.val + " "));

    }

    public static void LevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree();
        System.out.println("PreOrder:: ");
        preOrder(treeNode);
        System.out.println("InOrder:: ");
        InOrder(treeNode);
        System.out.println("PostOrder:: ");
        PostOrder(treeNode);
        System.out.println("LevelOrder:: ");
        LevelOrder(treeNode);
    }
}
