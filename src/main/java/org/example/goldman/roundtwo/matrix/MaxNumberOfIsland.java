package org.example.goldman.roundtwo.matrix;

public class MaxNumberOfIsland {

    public static void dfs(int [][]grid, int m, int n,  boolean [][]visited){
        if(m >= grid.length || m < 0 || n >= grid[0].length || n < 0 ||  grid[m][n] == 0 || visited[m][n]){
            return;
        }
        visited[m][n] = true;
        grid[m][n] = 0;
        dfs(grid, m+1, n, visited);
        dfs(grid, m-1, n, visited);
        dfs(grid, m, n+1, visited);
        dfs(grid, m, n-1, visited);
    }

    public static void MaxNumberOfIsland(int [][]grid, int m, int n,  boolean [][]visited){
        int islandCount = 0;
        for(int i=0; i < m ;i++){
            for(int j=0; j < n ; j++){
                if(grid[i][j] == 1){
                    islandCount++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        System.out.println("Island Count:: " + islandCount);
    }


    public static void main(String[] args) {
        int [][]grid = {
                {1,1,1,1,0},
                {1,1,0,1,0},
                {1,1,0,0,0},
                {0,0,0,0,0}
        };
        int m = grid.length;
        int n = grid[0].length;
        boolean [][]visited = new boolean[m][n];
        MaxNumberOfIsland(grid, m, n , visited);
    }
}
