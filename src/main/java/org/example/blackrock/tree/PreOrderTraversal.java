package org.example.blackrock.tree;

import java.util.*;
import java.math.*;
import java.io.*;

public class PreOrderTraversal {

    public static void preOrder(TreeNodeBR root){
        Stack<TreeNodeBR> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNodeBR node = stack.pop();
            System.out.println(node.val + " ");

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getTree();
        preOrder(root);
    }
}
