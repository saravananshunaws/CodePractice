package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int N = 5;
        int Arr[] = {1,2,3,-2,5};

        int currentSum = Arr[0], maxSum = Arr[0];
        for(int i=0; i < N; i++){
            currentSum = Math.max( Arr[i], currentSum + Arr[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println("Max Sum :: " + maxSum);
    }
}
