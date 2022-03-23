package org.example.meta.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class MaxAreaOfIsland {
    private static int[][] DIRS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1},
            {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};

    public static int[] findAreaOfIslands(int[][] ocean) {
        boolean[][] visited = new boolean[ocean.length][ocean[0].length];
        int[] islands = new int[ocean.length * ocean[0].length];

        int k = 0;

        for (int i = 0; i < ocean.length; i++) {
            for (int j = 0; j < ocean[i].length; j++) {
                if (visited[i][j] || ocean[i][j] == 0) {
                    continue;
                }

                islands[k++] = getAreaOfIsland(i, j, ocean, visited);
            }
        }

        return Arrays.copyOf(islands, k);
    }

    private static int getAreaOfIsland(int i, int j, int[][] ocean, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= ocean.length || j >= ocean[0].length ||
                ocean[i][j] == 0 || visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int area = 1;
        for (int[] dir :  DIRS) {
            area += getAreaOfIsland(i + dir[0], j + dir[1], ocean, visited);
        }

        return area;
    }
}
