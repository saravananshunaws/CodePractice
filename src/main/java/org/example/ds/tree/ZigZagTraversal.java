package org.example.ds.tree;

import com.sun.source.tree.Tree;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public static void zigZag(TreeNode tree){
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = true;
        List<List<TreeNode>> mainList = new ArrayList<>();
        queue.add(tree);
        int height = 0;
        while (!queue.isEmpty()){
            int size = queue.size();

            List<TreeNode> subNode = new ArrayList<>();
            for(int i=0; i < size; i++){
                TreeNode node = queue.poll();
                if(leftToRight){
                    subNode.add(node);
                }else{
                    subNode.add(0, node);
                }

                if(node.left != null){
                    queue.add(node.left);
                }

                if(node.right != null){
                    queue.add(node.right);
                }

            }
            mainList.add(subNode);
            leftToRight = !leftToRight;
            height++;
        }
        System.out.println("Height:: " + height);
        mainList.stream().forEach(innerList -> {
            System.out.println();
            innerList.stream().forEach(i -> System.out.print(i +" "));
        });
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree();
        zigZag(treeNode);
    }
}
