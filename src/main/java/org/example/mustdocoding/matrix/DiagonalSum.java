package org.example.mustdocoding.matrix;

public class DiagonalSum {

    public static void diagonalSum(int[][] matrix) {
        int m = matrix.length;;
        int n = matrix[0].length;

        int sum = matrix[0][0];
        for(int i=0, j=0 ; i < m -1 && j < n -1; i++, j++){
            sum += matrix[i + 1][j + 1];
        }
        System.out.println("Left Diagnoal Sum :: " + sum);
        sum = matrix[0][n-1];
        for(int i=0, j=n-1 ; i < m -1 && j >=0 ; i++, j--){
            sum += matrix[i + 1][j - 1];
        }
        System.out.println("Right Diagnoal Sum :: " + sum);

    }

    public static void main(String[] args) {
        int[][] imatric = { {1, 2, 10},
                            {4, 5, 6},
                            {7, 8, 9}};
        diagonalSum(imatric);
    }
}
