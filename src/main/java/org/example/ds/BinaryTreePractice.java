package org.example.ds;

import java.util.Stack;

public class BinaryTreePractice {

    public static void main(String[] args) {
        BinaryTreePractice binaryTree = new BinaryTreePractice();
        Node root = binaryTree.createTree();
        //System.out.println("Max Depth " + binaryTree.maxDepth(root));
       // binaryTree.printKthNode(root, 1);
        binaryTree.inOrder(root);
    }

    public Node createTree(){
          /* Construct the following tree
                   1
                 /  \
                /    \
               2       3
              / \      / \
             /   \     /  \
            4     5    6   7

        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        return root;
    }

    public int maxDepth(Node node){
        if(node == null){
            return 0;
        }
        return Math.max(maxDepth(node.left), maxDepth(node.right))  +1;
    }

    public void printKthNode(Node node, int level){
        if(node == null){
            return;
        }
        if(level == 3){
            System.out.println(node.data);
        }
        int inc = ++level;
        printKthNode(node.left, inc);
        printKthNode(node.right, inc);
    }

    public void preOrder(Node root){
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        stack.push(curr);
        while(!stack.empty()){
            curr = stack.pop();
            System.out.println(curr.data);
            if(curr.right != null){
                stack.push(curr.right);
            }

            if(curr.left != null){
                stack.push(curr.left );
            }
        }
    }

    public void inOrder(Node root){
        Node curr = root;
        Stack<Node> stack = new Stack<>();
        LinkedList currList = null;
        LinkedList head = null;
        while(!stack.empty() || curr != null){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                System.out.println(curr.data);
                if(currList == null) {
                    currList = new LinkedList();
                    currList.data = curr.data;
                    head = currList;
                }else{
                    currList.right = new LinkedList();
                    currList.right.data = curr.data;
                    currList = currList.right;
                }
                curr = curr.right;
            }
        }
        System.out.println(head);
    }
}

class LinkedList{
    public int data;
    public LinkedList left, right;

    @Override
    public String toString() {
        return "LinkedList{" +
                "data=" + data +
                ", left=" + left.data +
                ", right=" + right.data +
                '}';
    }
}