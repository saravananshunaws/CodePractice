package org.example.goldman.roundtwo.tree;

import java.util.*;

public class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum,  List<Integer> path,
                                                List<List<Integer>> allPaths) {
        if(root == null){
            return null;
        }
        path.add(root.val);
        if(root.val == sum  && root.left ==  null && root.right == null){
            allPaths.add(new ArrayList<>(path));
        }
        else{
            findPaths(root.left, sum - root.val, path, allPaths);
            findPaths(root.right, sum - root.val, path, allPaths);
        }
        path.remove(path.size() - 1);
        return allPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum, path, allPaths);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
