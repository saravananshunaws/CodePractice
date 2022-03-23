package org.example.mustdocoding.matrix;

public class PathWithMaximumGold {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int dfs(int[][] grid, int m, int n, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][i]) {
            return 0;
        }

        visited[i][j] = true;

        int a = dfs(grid, m, n, i - 1, j, visited);
        int b = dfs(grid, m, n, i + 1, j, visited);
        int c = dfs(grid, m, n, i, j + 1, visited);
        int d = dfs(grid, m, n, i, j - 1, visited);

        visited[i][j] = false;

        return grid[i][j] + Math.max(a, Math.max(Math.max(c, d), b));
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0}, {5, 8, 7}, {0, 9, 0}};
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    ans = Math.max(ans, dfs(grid, m, n, i, j, visited));
                }
            }
        }
        System.out.println("Answer  :: " + ans);
    }
}
