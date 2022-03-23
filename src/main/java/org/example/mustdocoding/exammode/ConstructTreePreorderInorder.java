package org.example.mustdocoding.exammode;

import org.example.generic.TreeNodeGeneric;

import java.util.*;
import java.math.*;
import java.io.*;

public class ConstructTreePreorderInorder {
    static int preOrderIndex = 0;
    public static void ConstructTreePreorderInorder(int[] preorder, int[] inorder){
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i =0; i < inorder.length ; i++){
            inOrderMap.put(inorder[i], i);
        }

        TreeNodeGeneric node =buildTree(preorder, inOrderMap, 0, preorder.length -1);
        System.out.println("Node :: " + node);
    }

    public static TreeNodeGeneric buildTree(int[] preorder,  Map<Integer, Integer> inOrderMap, int left, int right){
        if(left > right){
            return null;
        }
        int value = preorder[preOrderIndex++];
        TreeNodeGeneric node = new TreeNodeGeneric(value);
        node.left =  buildTree(preorder, inOrderMap, left , inOrderMap.get(value) - 1);
        node.right =  buildTree(preorder, inOrderMap, inOrderMap.get(value) + 1 , right);

        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        ConstructTreePreorderInorder(preorder, inorder);
    }
}
