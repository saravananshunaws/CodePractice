package org.example.mustdocoding.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions {

    public static void dfs(String[][] chars, int m, int n, int i, int j, boolean [][]visited ){
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || chars[i][j] != "O"){
            return ;
        }

        if(chars[i][j] == "O"){
            chars[i][j] = "X";
            visited[i][j] = true;
        }

        dfs(chars, m, n , i-1, j, visited);
        dfs(chars, m, n , i+1, j, visited);
        dfs(chars, m, n , i, j - 1, visited);
        dfs(chars, m, n , i, j + 1, visited);

    }

    public static void main(String[] args) {
        String[][] chars = {{"X", "X", "X", "X"}, {"X", "O", "O", "X"}, {"X", "X", "O", "X"}, {"X", "O", "X", "X"}};
        int m = chars.length;
        int n = chars[0].length;

        for (String[] row : chars) {
            System.out.println(Arrays.toString(row));
        }


        List<int[]> borders = new LinkedList<>();
        boolean [][]visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            borders.add(new int[]{i, 0});
            borders.add(new int[]{n - 1, i});
        }

        for (int i = 0; i < n; i++) {
            borders.add(new int[]{0, i});
            borders.add(new int[]{m - 1, i});
        }

        for (int i = 0; i < borders.size(); i++) {
            int []dfsChars =  borders.get(i);
           dfs(chars, m, n, dfsChars[0], dfsChars[1], visited);
        }

        for (String[] row : chars) {
            System.out.println(Arrays.toString(row));
        }
    }
}
