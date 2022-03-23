package org.example.studyplan.DS1.matrix;

public class BoundryTraversal {
    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int direction = 0, R = grid.length, C = grid[0].length;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || i == R - 1) {
                    System.out.print(grid[i][j] + " ");
                } else if (j == 0 || j == C - 1) {
                    System.out.print(grid[i][j] + " ");
                }else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}
