package org.example.mustdocoding.matrix;

public class NumberOfIslands {

    public static void dfs(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 0;
        visited[i][j] = true;


        dfs(grid, m, n, i - 1, j, visited);
        dfs(grid, m, n, i + 1, j, visited);
        dfs(grid, m, n, i, j - 1, visited);
        dfs(grid, m, n, i, j + 1, visited);

    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}
        };
        int m = grid.length;
        int n = grid[0].length;
        int numOfIsland = 0;
        boolean [][]visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    numOfIsland++;
                    dfs(grid, m, n, i, j, visited);
                }
            }
        }
        System.out.println("Island Count :: " + numOfIsland);
    }
}
