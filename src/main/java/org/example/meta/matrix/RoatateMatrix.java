package org.example.meta.matrix;

import java.util.Arrays;

public class RoatateMatrix {

    // In-place rotate it by 90 degrees in a clockwise direction
    public static void rotateClockWise(int[][] mat) {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        // `N × N` matrix
        int N = mat.length;

        // Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // swap columns
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][N - j - 1];
                mat[i][N - j - 1] = temp;
            }
        }
    }

    public static void rotateAntiClockWise(int[][] mat) {
        // base case
        if (mat == null || mat.length == 0) {
            return;
        }

        // `N × N` matrix
        int N = mat.length;

        // Transpose the matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                // swap `mat[i][j]` with `mat[j][i]`
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // swap rows
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N; j++) {
                // swap `mat[i][j]` with `mat[N-i-1][j]`
                int temp = mat[i][j];
                mat[i][j] = mat[N - i - 1][j];
                mat[N - i - 1][j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };
        rotateClockWise(mat);
        for (var r : mat) {
            System.out.println(Arrays.toString(r));
        }
    }
}
