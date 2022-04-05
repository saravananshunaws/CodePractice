package org.example.mustdocoding.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class BombEnemy {
    static int max = 0;

    public static void dfs(String [][]grid, int m, int n, int r, int c, boolean [][]visited){
        if (r < 0 || c < 0 || r >= m || c >= n || !grid[r][c].equals("0") || !visited[r][c]) {
            return;
        }

        if(grid[r][c] == "E"){

        }
        dfs(grid, m, n, r + 1, c, visited);
        dfs(grid, m, n, r - 1, c, visited);
        dfs(grid, m, n, r , c + 1, visited);
        dfs(grid, m, n, r , c - 1, visited);

       // if()

    }

    public static void main(String[] args) {
        String [][]grid = {{"0","E","0","0"},{"E","0","W","E"},{"0","E","0","0"}};


    }
}
