package org.example.ds.tree.thurs28;


import org.example.ds.tree.TreeNode;
import java.util.*;


public class LevelOrderTraversal {

    public static void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                System.out.print(node.val +" ");

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        return (1 + Math.max(height(root.left) , height(root.right)));
    }

    public static int minheight(TreeNode root){
        if(root == null){
            return 0;
        }

        return (1 + Math.min(height(root.left) , height(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        levelOrderTraversal(root);
        System.out.println();
        System.out.println("Height:: " + height(root));
        System.out.println();
        System.out.println("Min Height:: " + minheight(root));
    }
}
