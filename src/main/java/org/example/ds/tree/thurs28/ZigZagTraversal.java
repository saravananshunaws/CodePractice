package org.example.ds.tree.thurs28;

import org.example.ds.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public static void zigZag(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //System.out.print(node.val +" ");

                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(level);
        }
        System.out.println("Result:: " + result);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        zigZag(root);
    }
}
