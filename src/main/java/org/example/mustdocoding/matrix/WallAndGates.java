package org.example.mustdocoding.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallAndGates {
    public static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;

    public static void bfs() {
        int[][] rooms = {{1, -1, 0, 1}, {1, 1, 1, -1}, {1, -1, 1, -1}, {0, -1, 1, 1}};

        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.add(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.add(new int[] { r, c });
            }
        }


        for (int [] room: rooms) {
            System.out.println(Arrays.toString(room));
        }
    }

    public static void main(String[] args) {
        bfs();
    }
}
