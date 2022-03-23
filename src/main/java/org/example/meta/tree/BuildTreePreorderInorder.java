package org.example.meta.tree;

import org.example.generic.TreeNodeGeneric;

import java.util.HashMap;
import java.util.Map;

public class BuildTreePreorderInorder {
    static int preOrderIndex = 0;

    public static TreeNodeGeneric buildTree(int[] preorder, Map<Integer, Integer> inOrderIndexMap, int left, int right) {
        if (left > right) {
            return null;
        }
        int value = preorder[preOrderIndex++];
        TreeNodeGeneric node = new TreeNodeGeneric(value);
        node.left = buildTree(preorder, inOrderIndexMap, left, inOrderIndexMap.get(value) -1);
        node.right = buildTree(preorder, inOrderIndexMap, inOrderIndexMap.get(value) + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        Map<Integer, Integer> inOrderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderIndexMap.put(inorder[i], i);
        }
        TreeNodeGeneric node = buildTree(preorder, inOrderIndexMap, 0, preorder.length -1);
        System.out.println("Node :: " + node);
    }
}
