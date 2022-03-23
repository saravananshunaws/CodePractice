package org.example.goldman.roundone.array.top50;

public class MinimumActivatedFountain {

    public static void main(String[] args) {
        int a[] = {3,4,1,1,0,0};
        int N = a.length;
        System.out.println("findMinActivatedFountain(a, N) " + findMinActivatedFountain(a, N));
        ;
    }

    public static int findMinActivatedFountain(int[] a, int N) {
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = -1;
        }

        int idxLeft;
        int idxRight;

        for (int i = 0; i < N; i++) {
            idxLeft = Math.max(i - a[i], 0);
            idxRight = Math.min(i + (a[i]  + 1), N);
            dp[idxLeft] = Math.max(dp[idxLeft], idxRight);
        }

        int cntfount = 1;
        int idxNext = 0;
        idxRight = dp[0];

        for (int i = 0; i < N; i++) {
            idxNext = Math.max(idxNext, dp[i]);
            if (i == idxRight) {
                cntfount++;
                idxRight = idxNext;
            }
        }
        return cntfount;

    }
}
