package org.example.mustdocoding.tree;

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

    public static void VerticalOrderTraversal(TreeNodeGeneric root) {
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        int column = 0;
        q.add(new Pair(root, column));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            TreeNodeGeneric node = p.node;
            int c = p.column;
            if (node != null) {
                if (!columnMap.containsKey(c)) {
                    columnMap.put(c, new ArrayList<>());
                }
                columnMap.get(c).add(node.val);
                q.add(new Pair(node.left, column - 1));
                q.add(new Pair(node.right, column + 1));
            }
        }
        System.out.println(columnMap);
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
        VerticalOrderTraversal(tree);
    }
}
