package org.example.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForSum {

    public static void AllPathsForSum(TreeNode root, int sum, List<Integer> currentPath, List< List<Integer>> allPath){
        if(root == null){
            return;
        }
        currentPath.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            allPath.add(new ArrayList<>(currentPath));
        }else{
            AllPathsForSum(root.left, sum - root.val, currentPath, allPath);
            AllPathsForSum(root.right, sum - root.val, currentPath, allPath);
        }

        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<Integer> currentPath = new ArrayList<>();
        List< List<Integer>> allPath = new ArrayList<>();
        AllPathsForSum(root, 70, currentPath, allPath);
        System.out.println(allPath);
    }
}
