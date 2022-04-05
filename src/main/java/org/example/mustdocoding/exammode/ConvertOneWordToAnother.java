package org.example.mustdocoding.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class ConvertOneWordToAnother {
    public static void main(String[] args) {
        String  word1 = "sea", word2 = "eat";
        int m = word1.length();
        int n = word2.length();
        int [][]dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 || j== 0){
                    continue;
                }
                else if(word1.charAt(i -1) == word2.charAt(j - 1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
