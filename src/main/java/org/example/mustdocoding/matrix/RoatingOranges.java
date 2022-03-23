package org.example.mustdocoding.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class RoatingOranges {
    public static void main(String[] args) {
        int [][]grid = {{2,1,1}, {1,1,0},{0,1,1}};
        int minute = 0;
        boolean roaten = false;
        int m = grid.length;
        int n = grid[0].length;
        while(true){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 2){

                        if(i-1 >=0 && grid[i-1][j] == 1){
                            grid[i-1][j] = grid[i][j] + 1;
                            roaten = true;
                        }

                        if(i+1 < m && grid[i+1][j] == 1){
                            grid[i+1][j] =  grid[i][j] + 1;;
                            roaten = true;
                        }
                        if(j-1 >= 0 && grid[i][j-1] == 1){
                            grid[i][j-1] =  grid[i][j] + 1;;
                            roaten = true;
                        }
                        if(j+1 < n && grid[i][j + 1] == 1){
                            grid[i][j + 1] =  grid[i][j] + 1;;
                            roaten = true;
                        }
                    }
                }
            }
            if(!roaten){
                break;
            }

            roaten = false;
            minute++;
        }
        System.out.println("Count :: " + minute);
    }
}
