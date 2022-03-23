package org.example.goldman.roundthree.matrix;

public class PathWithMaximumGold {
    boolean[][] vis;
    public int getMaximumGold(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans, find(grid, i, j));
                }
            }
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }

    public int find(int[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] == 0)
            return 0;
        vis[i][j] = true;
        int ans = Integer.MIN_VALUE;
        ans = Math.max(ans, find(grid, i + 1, j));
        ans = Math.max(ans, find(grid, i, j + 1));
        ans = Math.max(ans, find(grid, i, j - 1));
        ans = Math.max(ans, find(grid, i - 1, j));
        vis[i][j] = false;
        return ans + grid[i][j];
    }
}
