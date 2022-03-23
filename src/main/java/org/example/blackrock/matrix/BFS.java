package org.example.blackrock.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static int numIslands(char[][] islandGrid) {
        int numberOfIsland = 0;
        int R = islandGrid.length;
        int C = islandGrid[0].length;
        boolean[][] visited = new boolean[R][C];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && islandGrid[i][j] == '1') {
                    numberOfIsland++;
                    q.add(new int[]{i, j});
                    bfs(q, islandGrid, visited, R, C);
                }
            }
        }

        return numberOfIsland;
    }

    public static void bfs(Queue<int[]> q, char[][] islandGrid, boolean[][] visited, int R, int C) {
        while (!q.isEmpty()) {
            int[] arr = q.poll();

            int i = arr[0];
            int j = arr[1];

            if (i < 0 || j < 0 || i >= R || j >= C || visited[i][j] || islandGrid[i][j] != '1') {
                continue;
            }

            visited[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int adjX = i + dir[k][0];
                int adjY = j + dir[k][1];
                q.add(new int[]{adjX, adjY});
            }
        }
    }

    public static void main(String[] args) {
        char[][] islandGrid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        System.out.println("Number Of Island:: " + numIslands(islandGrid));
    }
}
