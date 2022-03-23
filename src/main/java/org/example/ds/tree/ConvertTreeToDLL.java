package org.example.ds.tree;

import java.util.Stack;

public class ConvertTreeToDLL {

    public static void ConvertTreeToDLL(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Node rootNode = null;
        Node currentNode = null;
        Node prevNode = null;
        while (!stack.isEmpty()){
            while (root.left != null){
                stack.push(root.left);
                root = root.left;
            }

            TreeNode node = stack.pop();
            System.out.print(node.val + " ");

            if(rootNode == null){
                rootNode = new Node(node.val);
                rootNode.data = node.val;
                currentNode = rootNode;
                prevNode = rootNode;
            }else {
                Node node1 = new Node(node.val);
                currentNode.next = node1;
                node1.prev = currentNode;
                currentNode = node1;
            }

            if(node.right != null){
                stack.push(node.right);
                root = node.right;
            }
        }
        System.out.println("DLL:: "+rootNode);
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.getTree();
        ConvertTreeToDLL(root);
    }
}
