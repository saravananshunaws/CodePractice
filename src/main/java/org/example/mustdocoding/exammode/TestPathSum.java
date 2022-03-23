package org.example.mustdocoding.exammode;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class TestPathSum {
    public static void pathSum(TreeNodeGeneric root, int targetSum,  List<Integer> current ,List<List<Integer>> allPaths  ) {
        if(root ==  null){
            return ;
        }
        current.add(root.val);

        if(root.val == targetSum){
            allPaths.add(new ArrayList<>(current));
        }

        pathSum(root.left, targetSum - root.val, current, allPaths);
        pathSum(root.right, targetSum - root.val, current, allPaths);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> allPaths = new ArrayList<>();
        pathSum(root, 70,  current, allPaths);
        System.out.println("All Paths :: " + allPaths);
    }

}
