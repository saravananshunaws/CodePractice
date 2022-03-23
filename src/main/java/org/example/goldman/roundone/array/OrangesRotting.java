package org.example.goldman.roundone.array;

public class OrangesRotting {

    public static void OrangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean changed = true;
        int count = 0;
        while (true) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        if (i + 1 >= 0 && (i + 1) >= m && grid[i + 1][j] == 1) {
                            changed = true;
                        }

                        if (i - 1 >= 0 && (i - 1) >= m && grid[i - 1][j] == 1) {
                            changed = true;
                        }

                        if (j + 1 >= 0 && (j + 1) >= m && grid[i][j + 1] == 1) {
                            changed = true;
                        }

                        if (j - 1 >= 0 && (j - 1) >= m && grid[i][j - 1] == 1) {
                            changed = true;
                        }
                    }
                }
            }


            if (!changed)
                break;
            else {
                count++;
            }
        }

        System.out.println("Hours:: " + count);
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        OrangesRotting(grid);
    }
}
