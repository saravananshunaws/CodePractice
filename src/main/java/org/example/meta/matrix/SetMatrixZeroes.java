package org.example.meta.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {

    public static void SetMatrixZeroes(int[][] matrix) {
        List<int[]> zeroes = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    zeroes.add(new int[]{i, j});
                }
            }
        }

        for (int[] cell : zeroes) {
            for (int j = 0; j < n; j++) {
                matrix[cell[0]][j] = 0;
            }

            for (int j = 0; j < m; j++) {
                matrix[j][cell[1]] = 0;
            }

        }

        for(int [] row: matrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        SetMatrixZeroes(matrix);
    }
}
