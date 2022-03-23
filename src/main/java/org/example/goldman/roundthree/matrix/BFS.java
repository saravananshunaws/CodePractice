package org.example.goldman.roundthree.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}
                       };

        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));

        int[] ROW = {-1, 0, 1, 0};
        int[] COL = {0, 1, 0, -1};
        boolean [][]vis = new boolean[m][n];
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                System.out.print(grid[p.x][p.y] + " ");

                for (int j = 0; j < 4; j++) {
                    int adjx = p.x + ROW[j];
                    int adjy = p.y + COL[j];

                    if(adjx >= 0 && adjx < m && adjy >=0 && adjy < n && vis[adjx][adjy] == false) {
                        q.add(new Pair(adjx, adjy));
                        vis[adjx][adjy] = true;
                    }
                }
            }
            System.out.println(" ");
        }
    }
}
