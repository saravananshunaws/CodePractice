package org.example.blackrock.tree;

import java.util.Stack;

public class FlattenBinaryTreeToLL {

    static class NodeLL{
        int val;
        NodeLL next;

        public NodeLL(int val){
            this.val = val;
        }
    }

    public static void preOrder(TreeNodeBR root){
        Stack<TreeNodeBR> stack = new Stack<>();
        stack.push(root);
        NodeLL rootNode = null, rootNodeOrig = null;

        while(!stack.isEmpty()){
            TreeNodeBR node = stack.pop();
            System.out.print(node.val + " ");
            if(rootNode == null){
                rootNode = new NodeLL(root.val);
                rootNodeOrig = rootNode;
            }else{
                rootNode.next = new NodeLL(node.val);
                rootNode = rootNode.next;
            }

            if(node.right != null){
                stack.push(node.right);
            }

            if(node.left != null){
                stack.push(node.left);
            }
        }

        System.out.println();

        while(rootNodeOrig != null){
            System.out.print(rootNodeOrig.val + " ");
            rootNodeOrig = rootNodeOrig.next;
        }
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getTree();
        preOrder(root);
    }
}
