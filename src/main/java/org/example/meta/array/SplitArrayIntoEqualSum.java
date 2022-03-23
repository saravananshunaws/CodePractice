package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class SplitArrayIntoEqualSum {
    public static void main(String[] args) {
        int arr[] = { 1 , 2 , 3 , 4 , 5 , 5  };
        int n = arr.length;
        int leftSum =0, rightSum =0, splitIndex = -1;
        for(int i=0; i < n; i++){
            leftSum += arr[i];

            rightSum =0;
            for(int j=i + 1; j < n; j++){
                rightSum += arr[j];
            }

            if(leftSum == rightSum){
                splitIndex = i + 1;
            }
        }

        for(int i=0; i < n; i++){
            if(i == splitIndex){
                System.out.println();
            }
            System.out.print(arr[i] +" ");
        }
    }
}
