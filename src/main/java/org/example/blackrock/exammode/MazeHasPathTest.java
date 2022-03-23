package org.example.blackrock.exammode;

import java.util.LinkedList;
import java.util.Queue;

public class MazeHasPathTest {

    static int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static boolean hasPath(int[][] maze) {
        int[] source = {0, 4};
        int[] dest = {4, 4};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int R = maze.length;
        int C = maze[0].length;
        boolean [][]visited = new boolean[R][C];
        while (!q.isEmpty()) {
            int []cell = q.poll();
            int x = cell[0];
            int y = cell[1];

            if(x == dest[0] && y == dest[1]){
                return true;
            }

            for(int []DIR : DIRS){

                while(x >= 0  && y >= 0 && x < R && y < C && maze[x][y] == 0 ){
                     x += DIR[0];
                     y += DIR[1];
                }

                x -= DIR[0];
                y -= DIR[1];

                if(!visited[x][y]){
                    visited[x][y] = true;
                    q.add(new int[]{x, y});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        System.out.println(hasPath(maze));
    }
}
