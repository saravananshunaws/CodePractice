package org.example.mustdocoding.exammode;

import org.example.generic.TreeNodeGeneric;

import java.util.*;

public class TreeTraversal {

    public static void preOrderRecur(TreeNodeGeneric root ){
        if(root == null){
            return;
        }

        System.out.print(root.val + " ");
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }

    public static void preOrderIter(TreeNodeGeneric root ){
        Stack<TreeNodeGeneric> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty()){
            TreeNodeGeneric node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                stack.add(node.right);
            }

            if(node.left != null){
                stack.add(node.left);
            }
        }
    }

    public static void inOrderIter(TreeNodeGeneric root ) {
        Stack<TreeNodeGeneric> stack = new Stack<>();
        //stack.add(root);
        TreeNodeGeneric curr = root;
        while(!stack.empty() || curr != null){

            while (curr != null){
                stack.add(curr);
                curr = curr.left;
            }

            TreeNodeGeneric node = stack.pop();
            System.out.print(node.val + " ");
            if(node.right != null){
                curr = node.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        preOrderRecur(root);
        System.out.println();
        preOrderIter(root);
        System.out.println();
        inOrderIter(root);
    }
}
