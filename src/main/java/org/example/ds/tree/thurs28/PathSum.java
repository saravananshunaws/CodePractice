package org.example.ds.tree.thurs28;

import org.example.ds.tree.TreeNode;

public class PathSum {
    public static boolean pathSum(TreeNode root, int key){
        if(root == null){
            return false;
        }

        if(root.val == key){
            return true;
        }
        if(pathSum(root.left, key - root.val) || pathSum(root.right, key - root.val)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        boolean exists = pathSum(root , 700);
        System.out.println("Exists:: " + exists);
    }
}
