package org.example.mustdocoding.exammode;

import org.example.generic.TreeNodeGeneric;

import java.util.*;

public class VerticalOrderTraversal {

    static class Pair {
        TreeNodeGeneric node;
        int column;

        public Pair(TreeNodeGeneric node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public static void verticalOrderTraversal(TreeNodeGeneric root) {
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        int column = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, column));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNodeGeneric node = p.node;
            int c = p.column;
            if(!columnMap.containsKey(c)){
                columnMap.put(c, new ArrayList<>());
            }
            columnMap.get(c).add(node.val);
            if(node.left != null) {
                q.add(new Pair(node.left, c - 1));
            }
            if(node.right != null) {
                q.add(new Pair(node.right, c + 1));
            }
        }

        System.out.println(columnMap);
    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        verticalOrderTraversal(root);
    }
}
