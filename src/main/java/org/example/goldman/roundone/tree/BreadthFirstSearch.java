package org.example.goldman.roundone.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void BreadthFirstSearch(TreeNodeGM root){
        Queue<TreeNodeGM> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> list = new ArrayList<>();
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for(int i=0; i < size; i++){
                TreeNodeGM treeNodeGM = q.poll();
                System.out.print(treeNodeGM.val + " ");

                if(leftToRight){
                    subList.add(treeNodeGM.val);
                }else{
                    subList.add(0, treeNodeGM.val);
                }

                if(treeNodeGM.left != null){
                    q.add(treeNodeGM.left);
                }

                if(treeNodeGM.right != null){
                    q.add(treeNodeGM.right);
                }
            }
            list.add(subList);
            leftToRight  = !leftToRight;
        }
        System.out.println();
        System.out.println(list);
    }

    public static void main(String[] args) {
        TreeNodeGM root = TreeNodeGM.getTree();
        BreadthFirstSearch(root);
    }
}
