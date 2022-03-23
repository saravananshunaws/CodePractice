package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.Stack;

public class PreOrderTraversal {
    public static void PreOrderTraversal(TreeNodeGeneric tree) {
        Stack<TreeNodeGeneric> stack = new Stack<>();
        stack.push(tree);
        while (!stack.empty()) {
            TreeNodeGeneric current = stack.pop();
            System.out.print(current.val + " ");

            if(current.right != null){
                stack.push(current.right);
            }

            if(current.left != null){
                stack.push(current.left);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
        PreOrderTraversal(tree);
    }
}
