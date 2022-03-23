package org.example.blackrock.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    private static final int[][] DIR = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private static int rows;
    private static int cols;
    private static int[][] landHeights;

    public static void pacificAtlanticWaterFlow(int[][] grid) {
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            pacificQueue.add(new int[]{0, i});
            pacificQueue.add(new int[]{rows - 1, i});
        }

        for (int i = 0; i < cols; i++) {
            atlanticQueue.add(new int[]{i, 0});
            atlanticQueue.add(new int[]{i, cols - 1});
        }

        boolean[][] pacificVisited = bfs(pacificQueue);
        boolean[][] atlanticVisited = bfs(atlanticQueue);

        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }

        System.out.println(commonCells);

    }

    public static boolean[][] bfs(Queue<int[]> q) {
        boolean[][] visited = new boolean[rows][cols];
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int x = cell[0];
            int y = cell[1];
            visited[x][y] = true;
            for (int[] dir : DIR) {
                int adjX = x + dir[0];
                int adjY = x + dir[1];

                if (adjX < 0 || adjX >= rows || adjY < 0 || adjY >= cols || visited[adjX][adjY]
                        || landHeights[adjX][adjY] < landHeights[x][y] ) {
                    continue;
                }

                q.add(new int[]{adjX, adjY});
            }
        }

        return visited;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        rows = grid.length;
        ;
        cols = grid[0].length;
        landHeights = grid;

        pacificAtlanticWaterFlow(grid);
    }
}
