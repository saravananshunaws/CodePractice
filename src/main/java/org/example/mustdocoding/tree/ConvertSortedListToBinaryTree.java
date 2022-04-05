package org.example.mustdocoding.tree;

import org.example.generic.TreeNodeGeneric;

public class ConvertSortedListToBinaryTree {

    public static TreeNodeGeneric binaryTree( int []arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        TreeNodeGeneric root = new TreeNodeGeneric(arr[mid]);
        root.left = binaryTree(arr, start, mid - 1);
        root.right = binaryTree(arr, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6};
        TreeNodeGeneric root = binaryTree(arr, 0 , arr.length -1 );
        PreOrderTraversal.PreOrderTraversal(root);
    }
}
