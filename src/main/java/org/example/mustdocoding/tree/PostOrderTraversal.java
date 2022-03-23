package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.Stack;

public class PostOrderTraversal {
    public static void PostOrderTraversal(TreeNodeGeneric tree) {
        Stack<TreeNodeGeneric> stack = new Stack<>();
        stack.push(tree);
        Stack<TreeNodeGeneric> out = new Stack<>();
        while (!stack.empty()) {
            TreeNodeGeneric current = stack.pop();
            out.push(current);
            
            if(current.left != null){
                stack.push(current.left);
            }

            if(current.right != null){
                stack.push(current.right);
            }
        }
        System.out.println();
        while(!out.empty()){
            System.out.print(out.pop() + " ");
        }
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
        PostOrderTraversal(tree);
    }
}
