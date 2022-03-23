package org.example.ds.tree;

import java.util.*;

public class HeightOfTree {

    public static int height(TreeNode root, int level)
    {
        // empty tree has a height of 0
        if (root == null) {
            return 0;
        }
        // create an empty queue and enqueue the root TreeNode
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        TreeNode front = null;
        int height = 0;
        List<List<TreeNode>> list = new ArrayList<>();
        List<TreeNode> list1 = null;
        // loop till queue is empty
        boolean nextNode  =  false;
        while (!queue.isEmpty())
        {
            int size = queue.size();
            list1 = new ArrayList<>();
            while (size-- > 0)
            {
                front = queue.poll();
                list1.add(front);

                if(nextNode){
                    System.out.println("Successor Node:: " + front.val);
                }

                if(front.val == level){
                    nextNode = true;
                }else {
                    nextNode = false;
                }
                if (front.left != null) {
                    queue.add(front.left);
                }
                if (front.right != null) {
                    queue.add(front.right);
                }
            }
            list.add(list1);
            height++;
        }
        //Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
        return height;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.getTree();
        height(treeNode, 30);
    }
}
