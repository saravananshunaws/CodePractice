package org.example.meta.heap;

import java.util.*;
import java.math.*;
import java.io.*;

public class KthLargestElementStream {
    int k;
    PriorityQueue<Integer> maxHeap;

    public KthLargestElementStream(int k, int []values){
        this.k = k;
        maxHeap = new PriorityQueue<>();
        for(int value : values){
            maxHeap.add(value);
        }

        while (maxHeap.size() > k){
            maxHeap.poll();
        }
    }

    public int add(int value){
        maxHeap.add(value);
        if(maxHeap.size() > k){
            maxHeap.poll();
        }
        System.out.println(maxHeap.peek());
        return maxHeap.peek();
    }

    public static void main(String[] args) {
         int []nums = {4, 5, 8, 2};
        KthLargestElementStream kthLargest = new KthLargestElementStream(3, nums);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}
