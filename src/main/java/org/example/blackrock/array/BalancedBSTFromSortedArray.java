package org.example.blackrock.array;

public class BalancedBSTFromSortedArray {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    public static Node balancedBst(int []arr, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) / 2;
        Node node = new Node(arr[mid]);

        node.left = balancedBst(arr, start, mid - 1);
        node.right = balancedBst(arr, mid + 1 , end);
        return node;
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4};
        Node node = balancedBst(arr, 0, arr.length - 1);
        System.out.println(node);
    }
}
