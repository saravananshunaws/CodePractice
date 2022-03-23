package org.example.studyplan.DS1.matrix;

import java.util.*;

public class BFSTraversal {

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFSTraversal(int[][] grid ){
        int []ROW = {-1, 0, 1, 0};
        int []COL = {0, 1, 0, -1};

        int m = grid.length, n = grid[0].length;
        boolean [][] visited = new boolean[m][n];

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
                continue;
            }
            visited[x][y] = true;
            System.out.print(grid[x][y] + " ");
            for(int i=0; i < 4; i ++){
                int addX = x + ROW[i];
                int addY = y + COL[i];

                q.add(new Pair(addX, addY));
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        BFSTraversal(grid);
    }
}
