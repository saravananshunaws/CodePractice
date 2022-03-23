package org.example.mustdocoding.iteration;

import java.util.*;
import java.math.*;
import java.io.*;

public class KthLargetsElement {

    public static void kthLargetsElement(int []arr, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(arr[i] > q.peek()){
                q.poll();
                q.add(arr[i]);
            }
        }

        System.out.println("kthLargetsElement :: " + q.peek());
    }

    public static void kthSmallestElement(int []arr, int k){
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            q.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            if(arr[i] < q.peek()){
                q.poll();
                q.add(arr[i]);
            }
        }

        System.out.println("kthSmallestElement :: " + q.peek());
    }


    public static void main(String[] args) {
        int []arr = {7, 4, 6, 3, 9, 1};
        int k = 2;
        kthLargetsElement(arr, k);
        kthSmallestElement(arr, k);
    }
}
