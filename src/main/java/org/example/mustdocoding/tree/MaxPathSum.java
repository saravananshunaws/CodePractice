package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class MaxPathSum {
    public static int maxSum = 0;
    public static void MaxPathSum(TreeNodeGeneric root){
        if(root == null){
            return;
        }
        int sum = root.val;
        if(root.left != null){
            sum += root.left.val;
        }
        if(root.right != null){
            sum += root.right.val;
        }
        if(sum > maxSum){
            maxSum = sum;
        }

        MaxPathSum(root.left);
        MaxPathSum(root.right);
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTreeWithNegates();
        MaxPathSum(root);
        System.out.println("Max Sum :: " + maxSum);
    }
}
