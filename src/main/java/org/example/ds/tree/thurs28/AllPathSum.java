package org.example.ds.tree.thurs28;

import org.example.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {
    public static void pathSum(TreeNode root, int key, List<Integer> currentPath, List<List<Integer>> allPath) {
        if (root == null) {
            return;
        }
        currentPath.add(root.val);
        if (root.val == key && root.left == null && root.right == null) {
            allPath.add(new ArrayList<>(currentPath));
        } else {
            pathSum(root.left, key - root.val, currentPath, allPath);
            pathSum(root.right, key - root.val, currentPath, allPath);
        }
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        List<Integer> currentPath = new ArrayList<>();
        List<List<Integer>> allPath = new ArrayList<>();

        pathSum(root, 70, currentPath, allPath);
        System.out.println("AllPath:: " + allPath);
    }
}
