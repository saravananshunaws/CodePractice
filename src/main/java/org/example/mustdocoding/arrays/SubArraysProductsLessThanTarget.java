package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class SubArraysProductsLessThanTarget {
    public static void main(String[] args) {
        int []arr = {2, 5, 3, 10};
        int target=30;
        List<List<Integer>> result = new ArrayList<>();
        double product = 1;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];

            while (product >= target && left < arr.length) {
                product /= arr[left++];
            }

            List<Integer> tempList = new LinkedList<>();
            for (int i = right; i >= left; i--) {
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }

        System.out.println("Result:: " + result);
    }
}
