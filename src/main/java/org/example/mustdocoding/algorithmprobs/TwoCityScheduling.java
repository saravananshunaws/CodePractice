package org.example.mustdocoding.algorithmprobs;

import java.util.Arrays;

public class TwoCityScheduling {
    public static int twoCitySchedCost(int[][] costs) {
        // Sort in ascending order of diff b/w cost to A and cost to B
        Arrays.sort(costs, (a, b) -> {
            int aDiff = a[0] - a[1];
            int bDiff = b[0] - b[1];
            return aDiff - bDiff;
        });
        int totalCost = 0;
        int n = costs.length;

        // first half of array is min for city A and second half for city B
        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                totalCost += costs[i][0];
            } else {
                totalCost += costs[i][1];
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        int[][] costs = {{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        twoCitySchedCost(costs);
    }
}
