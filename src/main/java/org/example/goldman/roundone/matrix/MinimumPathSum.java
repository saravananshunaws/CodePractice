package org.example.goldman.roundone.matrix;

public class MinimumPathSum {

    public static void MinimumPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < R; j++) {
                dp[i][j] = grid[i][j];
                if (i == 0 && j > 0) {
                    dp[0][j] += dp[0][j - 1];
                }

                if (j == 0 && i > 0) {
                    dp[i][0] += dp[i - 1][0];
                }

                if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(" dp[i][j] " + dp[R-1][C-1]);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]
                {
                        {4, 7, 8, 6, 4},
                        {6, 7, 3, 9, 2},
                        {3, 8, 1, 2, 4},
                        {7, 1, 7, 3, 7},
                        {2, 9, 8, 9, 3}
                };
        MinimumPathSum(grid);
    }
}
