package org.example.ds;

import java.util.ArrayList;
import java.util.List;

class GFG {


    static int maxCuts(int n, int a, int b, int c, String funcName) {
        if (n == 0)
            return 0;
        if (n <= -1)
            return -1;

        System.out.println("FuncName " + funcName);

        int res = Math.max(maxCuts(n - a, a, b, c, "Cut1"),
                Math.max(maxCuts(n - b, a, b, c, "Cut2"),
                        maxCuts(n - c, a, b, c, "Cut3")));

        if (res == -1)
            return -1;

        return res + 1;
    }

    public static void main(String[] args) {
        int n = 5, a = 2, b = 1, c = 5;

        System.out.println(maxCuts(n, a, b, c, "CutMain"));

    }

}