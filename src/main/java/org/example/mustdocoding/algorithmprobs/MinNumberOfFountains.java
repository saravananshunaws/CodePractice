package org.example.mustdocoding.algorithmprobs;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinNumberOfFountains {
    public static int minTaps(int n, int[] ranges) {
        int arr[] = new int [n+1];
        for(int i=0;i<n+1;i++){
            int s = Math.max(0,i-ranges[i]);
            int e = Math.min(i+ranges[i],n);
            arr[s] = Math.max(arr[s],e);
        }
        int ans =0;
        int maxD =arr[0];
        int tempD = arr[0];
        int i =0;
        for( i=1;i<arr.length && i<=maxD;i++){
            tempD = Math.max(tempD,arr[i]);
            if(i==maxD) {
                maxD = tempD;
                ans++;
            }

        }
        if (i == n+1) return ans;
        return -1;

    }

    public static void main(String[] args) {
        int n = 5;
        int [] ranges = {3,4,1,1,0,0};
        System.out.println(minTaps(n, ranges));
    }
}
