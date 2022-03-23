package org.example.mustdocoding.arrays;

import java.util.*;
import java.math.*;
import java.io.*;

public class EquibriumPoint {
    public static void main(String[] args) {
        int n = 5;
        int A[] = {1,3,5,2,2};
        int left = 0, right = 0;
        int leftSum = 0, rightSum = 0;
        for(int i=1; i < n-1; i++){
            left = i - 1;
            right = i + 1;
            leftSum = 0;
            rightSum = 0;
            while(left >= 0){
                leftSum += A[left--];
            }

            while(right < n){
                rightSum += A[right++];
            }

            if(leftSum  == rightSum){
                System.out.println("Equilibrium Point Index :: " + i  + ", " + A[i]);
            }
        }
    }
}
