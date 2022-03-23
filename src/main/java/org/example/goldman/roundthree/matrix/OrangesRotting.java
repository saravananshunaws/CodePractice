package org.example.goldman.roundthree.matrix;

public class OrangesRotting {
   public static  int R;
    public static  int C;
    static boolean issafe(int i, int j)
    {
        if (i >= 0 && i < R &&
                j >= 0 && j < C)
            return true;

        return false;
    }

    public static void orangesRotting(int[][] grid, int m, int n) {
        boolean changed = true;
        int hours = 0;
        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        if (issafe(i + 1, j)  && grid[i + 1][j] == 1) {
                            grid[i + 1][j] = 3;
                            changed = true;
                        }

                        if (issafe(i - 1, j)  && grid[i - 1][j] == 1) {
                            grid[i - 1][j] = 3;
                            changed = true;
                        }

                        if (issafe(i , j + 1)  && grid[i][j + 1] == 1) {
                            grid[i][j + 1] = 3;
                            changed = true;
                        }

                        if (issafe(i, j - 1)  && grid[i][j - 1] == 1) {
                            grid[i][j - 1] = 3;
                            changed = true;
                        }
                    }
                }
            }
            if (!changed) {
                break;
            }
            changed = false;
            hours++;
            staleHelper(grid);
        }
        System.out.println("Hours:: " + hours);
    }

    private static void staleHelper(int[][] grid){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 3) {
                    grid[i][j] = 2;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        int m = grid.length;
        int n = grid[0].length;

        R = m;
        C = n;
        orangesRotting(grid, m, n);
    }
}
