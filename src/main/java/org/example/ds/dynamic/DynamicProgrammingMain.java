package org.example.ds.dynamic;

import java.util.UUID;

public class DynamicProgrammingMain {
    static int getValue(int[] values, int rodLength) {
        int[] subSolutions = new int[rodLength + 1];

        for (int i = 1; i <= rodLength; i++) {
            int tmpMax = -1;
            for (int j = 1; j <= i; j++) {
                int temp1 = values[j-1];
                int temp2 = subSolutions[i - j];
                tmpMax = Math.max(tmpMax, temp1 + temp2);
            }
            subSolutions[i] = tmpMax;
        }
        return subSolutions[rodLength];
    }

    static int getValueRecur(int[] values, int length) {
        if (length <= 0)
            return 0;
        int tmpMax = -1;
        for (int i = 0; i < length; i++) {
            int temp = getValueRecur(values, length - i - 1);
            System.out.println("Recur return value:: i=" + i + ", length=" + length + ", temp=" + temp);
            System.out.println("values[i] + temp:: " + (values[i] + temp));
            tmpMax = Math.max(tmpMax, values[i] + temp);
            System.out.println("tmpMax:: " + tmpMax);
        }
        return tmpMax;
    }

    public static void main(String[] args) {
        int[] values = new int[]{3, 1, 5, 3, 9};
        int rodLength = 4;

        System.out.println("Max rod value: " + getValue(values, rodLength));
    }
}
