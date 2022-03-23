package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class PathSum {
    public static List<Integer> paths = new ArrayList<>();

    public static void allPathSum(TreeNodeGeneric root, List<Integer> currentPath, List<List<Integer>> result){
        if(root == null){
            return;
        }
        currentPath.add(root.val);
        if(root.left == null && root.right == null){
            result.add(new ArrayList<>(currentPath));
        } else{
            allPathSum(root.left, currentPath, result);
            allPathSum(root.right, currentPath, result);
        }
        currentPath.remove(currentPath.size() - 1);
    }


    public static boolean pathSum(TreeNodeGeneric root, int sum){
        if(root == null){
            return false;
        }
        if(root.val == sum && root.left == null && root.right == null){
            System.out.println("Path Exists....");
            return true;
        }
        return pathSum(root.left, sum - root.val) || pathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
       // System.out.println(pathSum(tree, 70));

        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        allPathSum(tree, currentPath, result);
        System.out.println("All path Sum Result:: " + result);
    }
}
