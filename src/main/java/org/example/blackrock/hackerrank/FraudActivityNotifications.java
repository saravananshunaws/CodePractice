package org.example.blackrock.hackerrank;

import java.util.Arrays;
import java.util.List;

public class FraudActivityNotifications {
    public static int activityNotifications(List<Integer> expenditure, int d) {
        int n = expenditure.size() - 1;
        int[] array = new int[d];
        int count = 1;

        int index = 0;
        for (int j = 0; j < d; j++) {
            array[index++] = expenditure.get(j);
        }

        for (int i = d + 1; i < n; i++) {
            double median;
            if (d % 2 == 0) {
                median = (array[array.length / 2] + array[(array.length / 2) - 1]) / 2;
            } else {
                median = array[array.length / 2];
            }

            if (i >= (median * 2)) {
                System.out.println("Send Notice:: " + i);
            }

            index = 0;
            for (int j = count; j <= d; j++) {
                array[index++] = expenditure.get(j);
            }
            count++;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<Integer> expenditure = Arrays.asList(2, 3, 4, 2, 3, 6, 8, 4, 5);
        int d = 5;
        activityNotifications(expenditure, d);
    }
}
