package org.example.ds.array;

import java.util.Arrays;

public class PascalTriangle {
    public static void main(String[] args) {
        int[][] matrix = new int[5][5];

        for (int[] row : matrix) {
            Arrays.fill(row, 0);
        }

        matrix[0][0] = 1;
        matrix[1][0] = 1;
        matrix[1][1] = 1;

        for(int i=2; i < 5; i++){
            matrix[i][0] = 1;
            for(int j=0; j < i + 1; j++){
                //matrix[i][j] = matrix[i-1][j-1] + matrix[i-1][j-2];k
                System.out.println(matrix[i-1][j] + matrix[i-1][j+1]);
                matrix[i][j + 1] = matrix[i-1][j] + matrix[i-1][j+1];
            }
        }

        for(int i =0; i < 5; i++){
            for(int j =0; j < 5; j++){
                //System.out.println("i, j "+ i + "," + j + ":: "+ matrix[i][j]);
            }
            System.out.println("---------------------");
        }
    }
}
