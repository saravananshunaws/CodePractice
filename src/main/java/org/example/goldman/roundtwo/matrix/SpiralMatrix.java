package org.example.goldman.roundtwo.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int [][]grid = { {1,2,3},
                         {4,5,6},
                         {7,8,9}};
        int rows = grid.length;
        int cols = grid[0].length;
        int down = rows - 1;
        int right = cols - 1;
        int up = 0, left =0;
        List<Integer> result = new ArrayList<>();

        while(result.size() < rows * cols){

            for(int row=left; row <= right; row++){
                result.add(grid[up][row]);
            }

            for(int col=up + 1; col <= down; col++){
                result.add(grid[right][col]);
            }

            if(up != down){
                for(int row = right - 1; row >= left; row--){
                    result.add(grid[down][row]);
                }
            }

            if(left != right){
                for(int col = down - 1; col > up; col--){
                    result.add(grid[left][col]);
                }
            }

            up++;
            right--;
            left++;
            down--;
        }
        System.out.println("Result:: " + result);
    }
}
