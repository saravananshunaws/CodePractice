package org.example.mustdocoding.matrix;

public class WordSearch {

    static int ROW = 0;
    static int COL = 0;

    static int [][]DIRS  = {{-1,0}, {0, 1}, {1,0}, {0, -1}};

    public static boolean backtrack(String word , char [][]board, int i, int j, int index, boolean [][]visited){

        if (index >= word.length())
            return true;

        char ch = word.charAt(index);
        if(i < 0 || i >= ROW  || j < 0 || j >= COL || board[i][j] != ch || visited[i][j]){
            return false;
        }

        System.out.println("board[i][j] " + board[i][j] + "  - "  + ch);

        boolean ret  = false;
        visited[i][j] = true;
        //board[i][j] = '#';
        for(int []DIR : DIRS){
             if(backtrack(word, board, i + DIR[0], j + DIR[1], index + 1, visited)){
                 return true;
             }
        }
        visited[i][j] = false;
        //board[i][j] = word.charAt(index);
        return ret;
    }

    public static void main(String[] args) {
        char [][]board = {{'A','B','C','E'},
                         {'S','F','C','S'},
                         {'A','D','E','E'}};
        String word = "ABCCED";

        ROW = board.length;;
        COL = board[0].length;
        boolean [][]visited = new boolean[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if(backtrack(word, board, i, j, 0, visited)){
                    System.out.println("word Found ");
                    return;
                }
            }
        }
    }
}
