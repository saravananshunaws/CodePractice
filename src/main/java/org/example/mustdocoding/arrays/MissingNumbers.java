package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class MissingNumbers {
    public static void main(String[] args) {

        int num = 10, sum = 0;
        int A[] = {6,1,2,8,3,4,7,10,5};
        for(int i = 1; i <= num; ++i){
            sum += i;
        }
        System.out.println("Sum :: " + sum);

        for(int i = 0; i < A.length; ++i){
            sum = sum - A[i];
        }

        System.out.println("Missing Number :: " + sum);
    }
}
