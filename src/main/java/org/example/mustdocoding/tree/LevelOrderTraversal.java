package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void LevelOrderTraversal(TreeNodeGeneric tree) {
        Queue<TreeNodeGeneric> q = new LinkedList<>();
        q.add(tree);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNodeGeneric node = q.poll();
                System.out.print(node.val + " ");

                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TreeNodeGeneric tree = TreeNodeGeneric.getTree();
        LevelOrderTraversal(tree);
    }
}
