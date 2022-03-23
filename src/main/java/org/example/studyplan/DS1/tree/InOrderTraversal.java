package org.example.studyplan.DS1.tree;

import java.util.Stack;

public class InOrderTraversal {

    public static void InOrderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.empty()){
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        InOrderTraversal(root);
    }
}
