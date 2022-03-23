package org.example.meta.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class BinaryTreePaths {

    public static void binaryTreePaths(TreeNodeGeneric root,  List<Integer> currentPath, List<List<Integer>> allPaths){
        if(root == null){
            return;
        }
        currentPath.add(root.val);
        if(root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(currentPath));
        }

        binaryTreePaths(root.left, currentPath, allPaths);
        binaryTreePaths(root.right, currentPath, allPaths);

        currentPath.remove(currentPath.size() -1);
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        binaryTreePaths(root, currentPath, allPaths);
        System.out.println("All Paths :: " + allPaths);
    }
}
