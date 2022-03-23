package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        Queue<TreeNodeGeneric> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeGeneric node = q.poll();
                if(leftToRight) {
                    list.add(node.val);
                }else{
                    list.add(0, node.val);
                }

                if(node.left != null){
                    q.add(node.left);
                }

                if(node.right != null){
                    q.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(list);
        }

        System.out.println("Result :: " + result);
    }
}
