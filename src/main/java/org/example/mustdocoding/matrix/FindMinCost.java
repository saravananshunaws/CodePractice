package org.example.mustdocoding.matrix;

public class FindMinCost {

    public static int findMinCost(int[][] cost) {
        int[][] dp = new int[cost.length][cost[0].length];
        int m = cost.length;
        int n = cost[0].length;
        for (int i = 0; i < cost.length; i++) {
            for (int j = 0; j < cost[0].length; j++) {
                dp[i][j] = cost[i][j];
                if (i == 0 && j > 0) {
                    dp[i][j] += dp[0][j - 1];
                } else if (j == 0 && i > 0) {
                    dp[i][j] += dp[i - 1][0];
                } else if (i > 0 && j > 0) {
                    dp[i][j] += Integer.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] cost =
                {
                        {4, 7, 8, 6, 4},
                        {6, 7, 3, 9, 2},
                        {3, 8, 1, 2, 4},
                        {7, 1, 7, 3, 7},
                        {2, 9, 8, 9, 3}
                };

        System.out.println("The minimum cost is " + findMinCost(cost));
    }
}
