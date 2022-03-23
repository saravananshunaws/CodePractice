package org.example.studyplan.DS1.matrix;

public class SnakePattern {
    public static void main(String[] args) {

        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int direction = 0, R = grid.length, C = grid[0].length;

        for (int i = 0; i < R; i++) {

            if (direction % 2 == 0) {
                for (int j = 0; j < C; j++) {
                    System.out.print(grid[i][j] + " ");
                }
            }else{
                for (int j = C - 1; j >= 0; j--) {
                    System.out.print(grid[i][j] + " ");
                }
            }
            direction++;
            System.out.println();
        }
    }
}
