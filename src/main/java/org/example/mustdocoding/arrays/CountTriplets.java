package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class CountTriplets {
    public static void main(String[] args) {
        int N = 4;
        Integer arr[] = {1, 5, 3, 2};

        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                if(set.contains(arr[i] + arr[j])){
                    System.out.println("Triplet Exists :: " + arr[i] + "  "  + arr[j] + " " + (arr[i] + arr[j]));
                }
            }
        }
    }
}
