package org.example.meta.tree;

import org.example.goldman.roundone.tree.TreeNodeGM;

import java.util.ArrayList;
import java.util.List;

public class AllPathSum {

    public static void AllPathSum(TreeNodeGM root, int sum, List<Integer> pathSum){

        if(root == null){
            return;
        }

        sum += root.val;
        if(root.left == null && root.right == null){
            pathSum.add(sum);
        }else{
            AllPathSum(root.left, sum, pathSum);
            AllPathSum(root.right, sum, pathSum);
        }
    }

    public static void pathExists(TreeNodeGM root, int target, int sum,  List<Integer> currPath, List<List<Integer>> allPaths){

        if(root == null){
            return;
        }

        currPath.add(root.val);
        if(root.val == sum && root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(currPath));
        }else{
           pathExists(root.left, target, sum - root.val, currPath, allPaths);
           pathExists(root.right, target, sum - root.val, currPath,   allPaths);
        }

        currPath.remove(currPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNodeGM root = TreeNodeGM.getTree();
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        //AllPathSum(root, 0, pathSum);
        //System.out.println("Path Sum :: " + pathSum);
        int traget = 70;
        pathExists(root, traget, traget, currPath, allPaths);
        System.out.println("All Paths :: " + allPaths);
    }
}
