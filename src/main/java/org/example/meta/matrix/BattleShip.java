package org.example.meta.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class BattleShip {

    public static void dfs( String [][]board, int m, int n, int i, int j, boolean [][]visited){
        if(i < 0 || i >= m || j < 0 || j >=n || visited[i][j] || !board[i][j].equals("X")){
            return;
        }

        visited[i][j] = true;

        dfs(board, m , n, i-1, j, visited);
        dfs(board, m , n, i+1, j, visited);
        dfs(board, m , n, i, j - 1, visited);
        dfs(board, m , n, i, j + 1, visited);
    }

    public static void main(String[] args) {
        String [][]board = {{"X",".",".","X"}, {".",".",".","X"},{".",".",".","X"}};

        int m = board.length;
        int n = board[0].length;

        boolean [][]visited = new boolean[m][n];
        int count  = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j].equals("X") && !visited[i][j]){
                    count++;
                    dfs(board, m , n, i, j, visited);
                }
            }
        }

        System.out.println("Count:: " + count);
    }

    static int [][] DIRS = {{-1,0}, {1,0}, {0,1}, {0,-1}};

    public static void bfs( String [][]board, int m, int n, boolean [][]visited){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int count  =0;
        while(!q.isEmpty()){
            int [] cell = q.poll();

            if(board[cell[0]][cell[1]].equals("X")){
                count++;
            }
        }
    }
}
