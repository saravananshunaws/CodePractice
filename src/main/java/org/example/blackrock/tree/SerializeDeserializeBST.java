package org.example.blackrock.tree;

import java.util.*;
import java.math.*;
import java.io.*;

public class SerializeDeserializeBST {

    public static void postOrder(StringBuffer sb, TreeNodeBR root){
        if(root == null)
            return;

        postOrder(sb, root.left);
        postOrder(sb, root.right);

        sb.append(root.val).append(" ");
    }

    public static void serialize(TreeNodeBR root){
        StringBuffer sb = new StringBuffer();
        postOrder(sb, root);
        System.out.println(sb);
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);

        deserialize(sb);
    }

    public static TreeNodeBR constructBST(ArrayDeque<Integer> q){
        if(q.isEmpty()){
            return null;
        }
        Integer val = q.getLast();
        q.removeLast();
        TreeNodeBR root = new TreeNodeBR(val);
        root.left = constructBST(q);
        root.right = constructBST(q);
        return root;
    }

    public static void deserialize(StringBuffer sb){
        ArrayDeque<Integer> nums = new ArrayDeque<Integer>();
        for (String s : sb.toString().split("\\s+"))
            nums.add(Integer.valueOf(s));

        TreeNodeBR node = constructBST(nums);
        System.out.println(node);
    }

    public static void main(String[] args) {
        TreeNodeBR root = TreeNodeBR.getBSTTree();
        serialize(root);

    }
}
