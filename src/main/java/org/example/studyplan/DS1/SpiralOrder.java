package org.example.studyplan.DS1;

import java.util.*;

public class SpiralOrder {

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3}, {4,5,6},{7,8,9 }};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        //to up, right, down, left
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int currentDirection = 1; //to right
        int x = 0;
        int y = 0;

        int matrixLength = matrix.length * matrix[0].length;
        for (int i = 0; i < matrixLength; i++) {
            //add current value to result and mark visited
            result.add(matrix[x][y]);
            matrix[x][y] = 101;

            //calculate new position
            int newX = x + directions[currentDirection][0];
            int newY = y + directions[currentDirection][1];

            if (isOutOfBoundaries(newX, newY, matrix)) {
                //change direction if new position is out of boundaries + calculate new position
                currentDirection = (currentDirection + 1) % 4;
                newX = x + directions[currentDirection][0];
                newY = y + directions[currentDirection][1];
            }

            x = newX;
            y = newY;
        }

        return result;
    }

    private static boolean isOutOfBoundaries(int x, int y, int[][] matrix) {
        return x == matrix.length || x == -1
                || y == matrix[0].length || y == -1
                || matrix[x][y] == 101;
    }


}
