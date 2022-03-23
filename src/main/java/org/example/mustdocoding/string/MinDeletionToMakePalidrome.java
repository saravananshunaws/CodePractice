package org.example.mustdocoding.string;

import java.util.*;
import java.math.*;
import java.io.*;

public class MinDeletionToMakePalidrome {
    public static void main(String[] args) {
        String S = "aebcbda";
        StringBuffer reversed = new StringBuffer(S);
        reversed = reversed.reverse();

        int m = S.length(), n = reversed.length();
        int [][]dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 || j ==0){
                    dp[i][j] = 0;
                } else if(S.charAt(i-1) == reversed.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        int index = dp[m][n];
        System.out.println("Remove Index :: " + (m - index));
    }
}
