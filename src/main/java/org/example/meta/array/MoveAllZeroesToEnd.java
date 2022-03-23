package org.example.meta.array;

import java.util.*;
import java.math.*;
import java.io.*;

public class MoveAllZeroesToEnd {
    public static void main(String[] args) {
        int []arr = {1,0,0,5,6,0,8,9};
        int n = arr.length;
        int readIndex = 0, writeIndex = 0;
        while(readIndex < n){
           if(arr[readIndex] != 0){
               arr[writeIndex] = arr[readIndex];
               writeIndex++;
           }
           readIndex++;
        }

        for (int i = writeIndex; i < n; i++) {
            arr[i] = 0;
        }

        System.out.println(Arrays.toString(arr));
    }
}
