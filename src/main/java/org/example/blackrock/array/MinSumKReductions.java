package org.example.blackrock.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinSumKReductions {
    // Function to obtain the minimum possible
    // sum from the array by K reductions
    public static int minSum(int a[], int n, int k)
    {
        PriorityQueue<Integer> maxheap
                = new PriorityQueue<>((one, two) -> two - one);
        for (int i = 0; i < n; i++)
            maxheap.add(a[i]);

        while (maxheap.size() > 0 && k > 0) {
            int max_ele = maxheap.poll();
            maxheap.add((int) Math.ceil(max_ele / 2));
            k -= 1;
        }

        int sum = 0;
        while (maxheap.size() > 0)
            sum += maxheap.poll();

        return sum;
    }

    // Driver Code
    public static void main(String[] args)
    {
        int n = 4;
        int k = 3;
        int a[] = { 20, 7, 5, 4 };
        System.out.println(minSum(a, n, k));
    }
}
