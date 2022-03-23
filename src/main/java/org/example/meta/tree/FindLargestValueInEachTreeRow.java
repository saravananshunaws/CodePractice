package org.example.meta.tree;

import com.sun.source.tree.Tree;
import org.example.generic.TreeNodeGeneric;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {

    public static void FindLargestValueInEachTreeRow(TreeNodeGeneric root) {
        Queue<TreeNodeGeneric> q = new LinkedList<>();
        q.add(root);
        Map<Integer, Integer> map = new HashMap<>();
        int row = 1;
        while(!q.isEmpty()){
            int size = q.size();
            int maxValueRow = 0;
            for (int i = 0; i < size; i++) {
                TreeNodeGeneric node  = q.poll();
                if(node.val > maxValueRow){
                    maxValueRow = node.val;
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            map.put(row, maxValueRow);
            row++;
        }

        System.out.println(map);
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        FindLargestValueInEachTreeRow(root);
    }

}
