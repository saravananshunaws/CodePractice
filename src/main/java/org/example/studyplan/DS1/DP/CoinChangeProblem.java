package org.example.studyplan.DS1.DP;

public class CoinChangeProblem {

    public static int countRecur(int[] S, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        int result = 0;

        for (int c : S) {
            result += countRecur(S, target - c);
        }

        return result;
    }

    // Function to find the total number of distinct ways to get
    // a change of `target` from an unlimited supply of coins in set `S`
    public static int count(int[] S, int n, int target)
    {
        if (target == 0) {
            return 1;
        }
        if (target < 0 || n < 0) {
            return 0;
        }
        int incl = count(S, n, target - S[n]);
        int excl = count(S, n - 1, target);
        return incl + excl;
    }


    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        int target = 4;
        System.out.println("countRecur is " + count(S, S.length - 1, target));
    }
}
