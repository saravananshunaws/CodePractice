package org.example.goldman.roundone.array;

public class MaxNoOfIsland {

    public static void dfs(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        visited[i][j] = true;
        dfs(grid, m, n, i + 1, j, visited);
        dfs(grid, m, n, i - 1, j, visited);
        dfs(grid, m, n, i, j + 1, visited);
        dfs(grid, m, n, i, j - 1, visited);
    }

    public static void MaxNoOfIsland(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int islandCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    islandCount++;
                    dfs(grid, m, n, i, j, visited);
                }
            }
        }
        System.out.println("Max Island:: " + islandCount);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        MaxNoOfIsland(grid, grid.length, grid[0].length);
    }
}
