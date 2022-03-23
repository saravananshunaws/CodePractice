package org.example.studyplan.DS1.matrix;

public class DFSRecurTraversal {
    public static void DFSRecurTraversal(int[][] grid, int row, int col, boolean [][] visited ){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || visited[row][col]){
            return;
        }

        visited[row][col] = true;
        System.out.print(grid[row][col] + " ");

        DFSRecurTraversal(grid, row+1, col, visited);
        DFSRecurTraversal(grid, row-1, col, visited);
        DFSRecurTraversal(grid, row, col+1, visited);
        DFSRecurTraversal(grid, row, col-1, visited);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        int m = grid.length, n = grid[0].length;
        boolean [][] visited = new boolean[m][n];

        DFSRecurTraversal(grid, 0, 0 , visited);
    }
}
