package org.example.mustdocoding.matrix;

public class DiagonalTraversalMatrix {

    public static void DiagonalTraversalMatrix(int[][] mat) {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        int M = mat.length;
        int N = mat[0].length;

        for (int r = 0; r < M; r++)
        {
            for (int i = r, j = 0; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.print(System.lineSeparator());
        }

        for (int c = 1; c < N; c++)
        {
            for (int i = M - 1, j = c; j < N && i >= 0; i--, j++) {
                System.out.print(mat[i][j] + " ");
            }

            System.out.print(System.lineSeparator());
        }
    }

    public static void main(String[] args) {
        int [][]imatric = {{1,2,3},
                            {4,5,6},
                            {7,8,9}};
        DiagonalTraversalMatrix(imatric);
    }

}
