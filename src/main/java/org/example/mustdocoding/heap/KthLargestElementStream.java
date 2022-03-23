package org.example.mustdocoding.heap;

import java.util.*;

public class KthLargestElementStream {

    private static int k;
    private PriorityQueue<Integer> heap;

    public KthLargestElementStream(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>();

        for (int num: nums) {
            heap.offer(num);
        }

        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) {
            heap.poll();
        }
        System.out.println(heap.peek());
        return heap.peek();
    }

    public static void main(String[] args) {
        int []nums = {4, 5, 8, 2};
        int k = 3;
        KthLargestElementStream kthLargest = new KthLargestElementStream(k , nums);
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8
    }
}
