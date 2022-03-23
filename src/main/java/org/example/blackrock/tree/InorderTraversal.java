package org.example.blackrock.tree;

import java.util.*;
import java.math.*;
import java.io.*;

public class InorderTraversal {

    public static void inOrder(TreeNodeBR root){
        Stack<TreeNodeBR> stack = new Stack<>();
        TreeNodeBR curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr= stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getTree();
        inOrder(root);
    }
}
