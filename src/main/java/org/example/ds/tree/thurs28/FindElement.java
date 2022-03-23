package org.example.ds.tree.thurs28;

import org.example.ds.tree.TreeNode;

public class FindElement {

    public static boolean findElement(TreeNode root){
        if(root == null){
            return false;
        }
        if(root.val == 100){
            return true;
        }

        return (findElement(root.left) || findElement(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        System.out.println("Element Found:: " + findElement(root));
    }
}
