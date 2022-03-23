package org.example.meta.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class SerializeDeserializeBinaryTree {

    public static void serialize(TreeNodeGeneric root, StringBuilder sb){
        if(root == null){
            sb.append("N").append(",");
            return;
        }
        int value = root.val;
        sb.append(value).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public static TreeNodeGeneric deSerialize(Deque<String> q){
        String value = q.pop();
        if(value.equals("N")){
            return null;
        }
        TreeNodeGeneric node = new TreeNodeGeneric(Integer.valueOf(value));
        node.left = deSerialize(q);
        node.right = deSerialize(q);
        return node;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        TreeNodeGeneric root = TreeNodeGeneric.getTree();
        serialize(root, sb);
        System.out.println(sb);

        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(  sb.toString().split(",")));
        TreeNodeGeneric result = deSerialize(q);
        System.out.println(result);
    }
}
