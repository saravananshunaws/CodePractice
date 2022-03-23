package org.example.blackrock.tree;

import java.util.*;
import java.math.*;
import java.io.*;

public class VerticalOrderTraversal {

    static class Pair{
        TreeNodeBR node;
        int column;

        public Pair(TreeNodeBR node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public static void verticalOrderTraversal(TreeNodeBR root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int column = 0;
        q.add(new Pair(root, column));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNodeBR node = p.node;
            int val  = node.val;
            int c = p.column;
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(val);

            if(node.left != null)
                q.add(new Pair(node.left, c - 1));
            if(node.right != null)
                q.add(new Pair(node.right, c  + 1));
        }

        List<Integer> sortedKeys = new ArrayList<>(map.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            System.out.println(map.get(k));
        }
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getTree();
        verticalOrderTraversal(root);
    }
}
