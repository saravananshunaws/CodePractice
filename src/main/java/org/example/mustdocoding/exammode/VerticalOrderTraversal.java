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

    public static void VerticalOrderTraversal(TreeNodeGeneric root) {
        Queue<Pair> q = new LinkedList<>();
        int column = 0;
        q.add(new Pair(root, column));
        Map<Integer, List<Integer>> map = new HashMap<>();
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (!map.containsKey(pair.column)) {
                map.put(pair.column, new ArrayList<>());
            }
            map.get(pair.column).add(pair.node.val);

            if (pair.node.left != null) {
                q.add(new Pair(pair.node.left, column - 1));
            }

            if (pair.node.right != null) {
                q.add(new Pair(pair.node.right, column + 1));
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        for (Integer i : list) {
            System.out.println(map.get(i));
        }

    }

    public static void main(String[] args) {
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        VerticalOrderTraversal(root);
    }
}
