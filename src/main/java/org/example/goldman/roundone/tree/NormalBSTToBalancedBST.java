package org.example.goldman.roundone.tree;

import java.util.ArrayList;
import java.util.List;

public class NormalBSTToBalancedBST {
    // A class to store a BST node
    static class Node {
        int data;
        Node left, right;

        // Constructor
        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBalancedBST(List<Node> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = nodes.get(mid);
        root.left = buildBalancedBST(nodes, start, mid  - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);
        return root;
    }

    public static Node constructBalancedBST(Node root) {
        List<Node> nodes = new ArrayList<>();
        Inorder(root, nodes);
        root = buildBalancedBST(nodes, 0, nodes.size() - 1);
        return root;
    }

    public static void Inorder(Node root, List<Node> nodes) {
        if (root == null) {
            return;
        }
        Inorder(root.left, nodes);
        nodes.add(root);
        Inorder(root.right, nodes);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.left.left = new Node(10);
        root.left.left.left = new Node(5);
        root.left.left.left.left = new Node(2);
        root.left.left.left.right = new Node(8);

        root = constructBalancedBST(root);

        System.out.print("Preorder traversal of the constructed BST is ");
        preorder(root);
    }

}
