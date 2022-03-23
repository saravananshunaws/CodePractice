package org.example.meta.exercise;

import java.util.*;
import java.math.*;
import java.io.*;

public class TestSpiralMatrix {
    
    public static void spiralPrint(int R, int C, int mat[][] ){
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;

        while (true)
        {
            if (left > right) {
                break;
            }

            // print top row
            for (int i = left; i <= right; i++) {
                System.out.print(mat[top][i] + " ");
            }
            top++;

            if (top > bottom) {
                break;
            }

            // print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(mat[i][right] + " ");
            }
            right--;

            if (left > right) {
                break;
            }

            // print bottom row
            for (int i = right; i >= left; i--) {
                System.out.print(mat[bottom][i] + " ");
            }
            bottom--;

            if (top > bottom) {
                break;
            }

            // print left column
            for (int i = bottom; i >= top; i--) {
                System.out.print(mat[i][left] + " ");
            }
            left++;
        }
    }
    
    // Driver Code
    public static void main(String[] args) {
        int R = 3;
        int C = 4;
        int a[][] = { {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}};

        // Function Call
        spiralPrint(R, C, a);
    }
}
