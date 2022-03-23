package org.example.mustdocoding.tree;

import org.example.generic.NArrTreeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class NArrLevelOrderTraversal {
    public static void main(String[] args) {
        NArrTreeGeneric root = NArrTreeGeneric.getTree();
        Queue<NArrTreeGeneric> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                NArrTreeGeneric node = q.poll();
                System.out.print(node.val + " ");
                if(node.children != null) {
                    for (int j = 0; j < node.children.size(); j++) {
                        q.add(node.children.get(j));
                    }
                }
            }
            System.out.println();
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node item : node.children) {
                stack.add(item);
            }
        }
        return output;
    }
}
