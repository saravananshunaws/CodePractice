package org.example.studyplan.DS1;

public class MinCost {
    // Iterative function to find the minimum cost to traverse
    // from the first cell to the last cell of a matrix
    public static int findMinCost(int[][] cost)
    {
        // base case
        if (cost == null || cost.length == 0) {
            return 0;
        }

        // `M × N` matrix
        int M = cost.length;
        int N = cost[0].length;

        // `T[i][j]` maintains the minimum cost to reach cell (i, j)
        // from cell (0, 0)
        int[][] T = new int[M][N];

        // fill the matrix in a bottom-up manner
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                T[i][j] = cost[i][j];

                // fill the first row (there is only one way to reach any cell
                // in the first row from its adjacent left cell)
                if (i == 0 && j > 0) {
                    T[0][j] += T[0][j - 1];
                }

                // fill the first column (there is only one way to reach any cell
                // in the first column from its adjacent top cell)
                else if (j == 0 && i > 0) {
                    T[i][0] += T[i - 1][0];
                }

                // fill the rest with the matrix (there are two ways to reach any
                // cell in the rest of the matrix, from its adjacent
                // left cell or adjacent top cell)
                else if (i > 0 && j > 0) {
                    T[i][j] += Integer.min(T[i - 1][j], T[i][j - 1]);
                }
            }
        }
        // last cell of `T[][]` stores the minimum cost to reach destination cell
        // (M-1, N-1) from source cell (0, 0)
        return T[M - 1][N - 1];
    }

    public static void main(String[] args)
    {
        int[][] cost =
                    {
                        { 1,3,1},
                        { 1,5,1 },
                        { 1,2,1 }
                    };

        System.out.print("The minimum cost is " + findMinCost(cost));
    }
}
