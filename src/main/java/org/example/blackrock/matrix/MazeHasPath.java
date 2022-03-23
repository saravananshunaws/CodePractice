package org.example.blackrock.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MazeHasPath {

    public static boolean hasPath(int[][] maze) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[] source = {0, 4};
        int[] dest = {4, 4};
        int R = maze.length;
        int C = maze[0].length;

        boolean [][]visited = new boolean[R][C];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] elem = q.poll();
            int x = elem[0];
            int y = elem[1];
            if(x == dest[0] && y == dest[1]){
                return true;
            }


            for (int i = 0; i < 4; i++) {

                while (x >= 0 && y >= 0 && x < R && y < C && maze[x][y] == 0) {
                    x += dirs[i][0];
                    y += dirs[i][1];
                }

                x -= dirs[i][0];
                y -= dirs[i][1];
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
