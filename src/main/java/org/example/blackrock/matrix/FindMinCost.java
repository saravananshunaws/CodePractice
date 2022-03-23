package org.example.blackrock.matrix;

public class FindMinCost {
    public static int findMinCost(int[][] cost) {
        int r = cost.length;
        int c = cost[0].length;
        int[][] dp = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                dp[i][j] = cost[i][j];

                if (i == 0 && j > 0) {
                    dp[0][j] += dp[i][j - 1];
                } else if (i > 0 && j == 0) {
                    dp[i][0] += dp[i - 1][j];
                } else if (i > 0 && j > 0) {
                    dp[i][j] += Math.min(dp[i - 1][j], dp[i][j-1]);
                }
            }
        }
        return dp[r-1][c-1];
    }

    public static void main(String[] args) {
        int[][] cost =
                {
                        { 4, 7, 8, 6, 4 },
                        { 6, 7, 3, 9, 2 },
                        { 3, 8, 1, 2, 4 },
                        { 7, 1, 7, 3, 7 },
                        { 2, 9, 8, 9, 3 }
                };

        System.out.println("The minimum cost is " + findMinCost(cost));
    }

}
