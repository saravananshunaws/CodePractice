package org.example.mustdocoding.string;

public class MinInsertionMakePalindromeStr {
    static int lcs(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        int i, j;
        for (i = 0; i <= m; i++) {
            for (j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;

                else
                    L[i][j] = Integer.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    static int findMinInsertionsLCS(String str, int n) {
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        String revString = sb.toString();
        return (n - lcs(str, revString, n, n));
    }

    static void minSubstituations(String s) {
        int n = s.length();
        int cc = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) == s.charAt(n - i - 1))
                continue;
            cc += 1;

            if (s.charAt(i) < s.charAt(n - i - 1))
                s = s.replace(s.charAt(n - i - 1), s.charAt(i));
            else
                s = s.replace(s.charAt(i), s.charAt(n - i - 1));
        }
        System.out.println("Minimum characters to be replaced = " + (cc));
        System.out.println(s);
    }

    public static void main(String args[]) {
        String str = "zeeks";
        System.out.println(findMinInsertionsLCS(str, str.length()));
        minSubstituations(str);
    }
}
