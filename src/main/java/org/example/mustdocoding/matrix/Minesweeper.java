package org.example.mustdocoding.matrix;

import java.util.*;
import java.math.*;
import java.io.*;

public class Minesweeper {
    private int[][] DIRS = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        expand(board, board.length, board[0].length, click[0], click[1]);
        return board;
    }

    private void expand(char[][] board, int R, int C, int r, int c) {
        if (board[r][c] != 'E') {
            if (board[r][c] == 'M') {
                board[r][c] = 'X';
            }
            return;
        }
        int numMines = countMines(board, R, C, r, c);
        if (numMines > 0) {
            board[r][c] = (char) ('0' + numMines);
            return;
        }
        board[r][c] = 'B';
        for (int i = 0; i < DIRS.length; i++) {
            int rr = r + DIRS[i][0], cc = c + DIRS[i][1];
            if (rr >= 0 && rr < R && cc >= 0 && cc < C && board[rr][cc] == 'E') {
                expand(board, R, C, rr, cc);
            }
        }
    }

    private int countMines(char[][] board, int R, int C, int r, int c) {
        int count = 0;
        for (int i = 0; i < DIRS.length; i++) {
            int rr = r + DIRS[i][0], cc = c + DIRS[i][1];
            if (rr >= 0 && rr < R && cc >= 0 && cc < C && board[rr][cc] == 'M') {
                count++;
            }
        }
        return count;
    }
}
