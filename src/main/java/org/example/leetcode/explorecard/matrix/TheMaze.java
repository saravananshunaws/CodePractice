package org.example.leetcode.explorecard.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
    static int ROWS ;
    static int COLS;
    static int [][] DIRS = {{-1,0}, {0,1}, {1,0}, {0, -1}};

    public static void bfs(int[][] maze, int []start, int []dest){
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        boolean [][]visited = new boolean[ROWS][COLS];
        visited[start[0]][start[1]] = true;
        while(!q.isEmpty()){
           int []cell = q.poll();

           if(cell[0] == dest[0] && cell[1] == dest[1]){
               System.out.println("Path Exists:: ");
               return;
           }
           for(int []DIR : DIRS){
               int adjX = cell[0] + DIR[0];
               int adjY = cell[1] + DIR[1];

               if(adjX < 0 || adjX >= ROWS || adjY < 0 || adjY >= COLS || maze[adjX][adjY] == 1){
                   continue;
               }

               if(!visited[adjX][adjY]) {
                   q.add(new int[]{adjX, adjY});
                   visited[adjX][adjY] = true;
               }
           }
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}};
        int[] start = {0, 4};
        int[] dest = {4, 4};

        ROWS = maze.length;
        COLS = maze[0].length;
        bfs(maze, start, dest);
    }
}

