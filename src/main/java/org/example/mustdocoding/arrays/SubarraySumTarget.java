package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class SubarraySumTarget {
    public static void main(String[] args) {
        int N = 5, S = 17;
        int A[] = {1,2,3,7,5};

        int start = 0, windowSum = 0, currentSum = 0;
        for(int i= 0; i < N; i++){
            currentSum += A[i];

            while(currentSum >= S){
                currentSum -= A[start];
                start++;
                windowSum = Math.max(windowSum, i - start + 1);
                System.out.println("Index :: " +  start + " " + i);
            }
        }

        System.out.println(windowSum);
    }
}
