package org.example.blackrock.matrix;

public class GetMaximumGold {

    static int sum = 0;

    public static int getMaximumGold(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int max_gold = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    max_gold = Math.max(max_gold, dfs(grid, i, j, visited));
                }
            }
        }
        return max_gold;
    }

    public static int dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 ||
                y >= grid[0].length || visited[x][y] || grid[x][y] == 0)
            return 0;

        visited[x][y] = true;

        sum += grid[x][y];

        int UP = dfs(grid, x + 1, y, visited);

        int DOWN = dfs(grid, x - 1, y, visited);

        int RIGHT = dfs(grid, x, y + 1, visited);

        int LEFT = dfs(grid, x, y - 1, visited);

        visited[x][y] = false;

        return grid[x][y] + max(UP, DOWN, RIGHT, LEFT);
    }

    public static int max(int i1, int i2, int i3, int i4) {
        int max1 = Math.max(i1, i2);
        int max2 = Math.max(i3, i4);

        return Math.max(max1, max2);
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 6, 0},
                {5, 8, 7},
                {0, 9, 0}};
        System.out.println(getMaximumGold(grid));
    }
}
