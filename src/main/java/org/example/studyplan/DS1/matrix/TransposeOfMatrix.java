package org.example.studyplan.DS1.matrix;

public class TransposeOfMatrix {
    static int n = 4;
    static void swap(int mat[][], int i, int j)
    {
        int temp = mat[i][j];
        mat[i][j] = mat[j][i];
        mat[j][i] = temp;
    }

    static void transpose(int mat[][])
    {

        for(int i = 0; i < n; i++)
            for(int j = i + 1; j < n; j++)
                swap(mat, i, j);
    }

    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int direction = 0, R = grid.length, C = grid[0].length;

        transpose(grid);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}
