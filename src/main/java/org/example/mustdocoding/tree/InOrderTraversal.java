package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.Stack;

public class InOrderTraversal {
    public static void InOrderTraversal(TreeNodeGeneric tree) {
        Stack<TreeNodeGeneric> stack = new Stack<>();
        TreeNodeGeneric current = tree;
        stack.push(tree);
        while (!stack.empty() || current != null) {

            while (current != null && current.left != null) {
                stack.push(current.left);
                current = current.left;
            }

            TreeNodeGeneric node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null)
                stack.push(node.right);
            current = node.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
        InOrderTraversal(tree);
    }
}
