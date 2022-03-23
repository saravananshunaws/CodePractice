package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class LongestSubSequence {
    static int findLongestConseqSubseq(int arr[], int N)
    {
        TreeSet<Integer> set = new TreeSet<>();
        for(int x:arr) set.add(x);

        int count = 1;
        int max = -1;

        for(Integer x:set)
        {
            if(set.contains(x+1)){
                count++;
            }
            else{
                max = Math.max(count, max);
                count=1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int N = 7;
        int arr[] = {2,7,1,9,4,5,3};
        System.out.println("Max :: " + findLongestConseqSubseq(arr, N));
    }
}
