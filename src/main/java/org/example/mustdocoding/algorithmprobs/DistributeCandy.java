package org.example.mustdocoding.algorithmprobs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DistributeCandy {
    public static int candy(List<Integer> A) {
        int n = A.size();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n - 1; i++) {
            if (A.get(i + 1) > A.get(i))
                candies[i + 1] = candies[i] + 1;
        }
        for (int i = n - 1; i > 0; i--) {
            if (A.get(i - 1) > A.get(i) && candies[i - 1] <= candies[i])
                candies[i - 1] = candies[i] + 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1};
        List<Integer> list = Arrays.stream(A).boxed().collect(Collectors.toList());
        candy(list);
    }
}
