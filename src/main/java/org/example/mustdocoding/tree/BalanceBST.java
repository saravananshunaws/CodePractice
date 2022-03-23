package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

public class BalanceBST {

    public static TreeNodeGeneric balanceBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNodeGeneric root = new TreeNodeGeneric(nums[mid]);
        root.left = balanceBST(nums, start, mid - 1);
        root.right = balanceBST(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        TreeNodeGeneric root = balanceBST(arr, 0, arr.length - 1);
        PreOrderTraversal.PreOrderTraversal(root);
    }
}
