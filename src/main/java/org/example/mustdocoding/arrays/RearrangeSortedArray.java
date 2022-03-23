package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class RearrangeSortedArray {
    public static void main(String[] args) {
        int N = 6;
        int arr[] = {1,2,3,4,5,6};
        int []result = new int[N];
        int start = 0, end = N -1;
        for(int i=0; i < N; ){
          result[i + 1] = arr[start++];
          result[i] = arr[end--];
          i = i + 2;
        }

        System.out.println(Arrays.toString(result));
    }
}
