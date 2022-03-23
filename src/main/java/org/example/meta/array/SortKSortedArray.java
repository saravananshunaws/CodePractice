package org.example.meta.array;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    // Function to sort a k–sorted array
    public static void sortKSortedArray(List<Integer> nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(nums.subList(0, k + 1));
        int index = 0;
        for (int i = k + 1; i < nums.size(); i++) {
            nums.set(index++, pq.poll());
            pq.add(nums.get(i));
        }
        while (!pq.isEmpty()) {
            nums.set(index++, pq.poll());
        }
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
        int k = 2;

        sortKSortedArray(nums, k);
        System.out.println(nums);
    }
}
