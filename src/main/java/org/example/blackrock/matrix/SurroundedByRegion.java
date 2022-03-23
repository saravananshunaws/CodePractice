package org.example.blackrock.matrix;

import java.util.LinkedList;

public class SurroundedByRegion {
    public static void main(String[] args) {
        char[][] grid = {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', '0', 'X'}};

        solve(grid);
    }

    public static void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0)
            return;

        int m = board.length;
        int n = board[0].length;

        printMatrix(board, m , n);

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        printMatrix(board, m , n);

        for (int j = 0; j < n; j++) {
            if (board[m - 1][j] == 'O') {
                bfs(board, m - 1, j);
            }
        }

        printMatrix(board, m , n);

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        printMatrix(board, m , n);

        for (int i = 0; i < m; i++) {
            if (board[i][n - 1] == 'O') {
                bfs(board, i, n - 1);
            }
        }

        printMatrix(board, m , n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
        printMatrix(board, m , n);

    }

    public static void bfs(char[][] board, int o, int p) {
        int m = board.length;
        int n = board[0].length;

        int index = o * n + p;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(index);
        board[o][p] = '1';

        while (!queue.isEmpty()) {
            int top = queue.poll();
            int i = top / n;
            int j = top % n;

            if (i - 1 >= 0 && board[i - 1][j] == 'O') {
                board[i - 1][j] = '1';
                queue.offer((i - 1) * n + j);
            }
            if (i + 1 < m && board[i + 1][j] == 'O') {
                board[i + 1][j] = '1';
                queue.offer((i + 1) * n + j);
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O') {
                board[i][j - 1] = '1';
                queue.offer(i * n + j - 1);
            }
            if (j + 1 < n && board[i][j + 1] == 'O') {
                board[i][j + 1] = '1';
                queue.offer(i * n + j + 1);
            }
        }
    }

    public static void printMatrix(char [][]board, int m , int n){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------");
    }
}
