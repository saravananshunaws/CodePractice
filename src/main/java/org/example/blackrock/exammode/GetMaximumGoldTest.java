package org.example.blackrock.exammode;

public class GetMaximumGoldTest {
    static int R = 0;
    static int C = 0;
    static int max = Integer.MIN_VALUE;

    public static int dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= R || j < 0 || j >= C || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int up = dfs(grid, i - 1, j, visited);
        int right = dfs(grid, i, j + 1, visited);
        int down = dfs(grid, i + 1, j, visited);
        int left = dfs(grid, i, j - 1, visited);

        visited[i][j] = false;

        return grid[i][j] + Math.max(Math.max(Math.max(up, right), down), left);
    }

    public static void getMaximumGold(int[][] grid) {
        R = grid.length;
        C = grid[0].length;

        boolean[][] visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }

        System.out.println("Max Gold:: " + max);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}};
        getMaximumGold(grid);
    }
}
