package org.example.blackrock.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class SpiralTraversal {
    public static void main(String[] args) {
        int  [][]grid = {
                {1,   2,  3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10,  9,  8, 7},
        };
        int top = 0, bottom = grid.length - 1;
        int left = 0, right = grid[0].length - 1;

        while (true){
            if(left > right){
                break;
            }

            for(int  i=0; i <= right; i++){
                System.out.print(grid[top][i] + " ");
            }
            top++;

            for(int  i=right; i <= bottom; i++){
                System.out.print(grid[right][i] + " ");
            }
            right--;

            for(int  i=0; i <= right; i++){
                System.out.print(grid[top][i] + " ");
            }
        }
    }
}
