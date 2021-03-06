package org.example.goldman.roundone.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPair {

    public static int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = 1;
        int result = 0;

        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                // List item 1 in the text
                right++;
            } else if (nums[right] - nums[left] > k) {
                // List item 2 in the text
                left++;
            } else {
                // List item 3 in the text
                left++;
                result++;
                while (left < nums.length && nums[left] == nums[left - 1])
                    left++;
            }
        }
        return result;
    }

    public static int findPairsMap(int[] nums, int k) {

        int result = 0;

        HashMap<Integer,Integer> counter = new HashMap<>();
        for (int n: nums) {
            counter.put(n, counter.getOrDefault(n, 0)+1);
        }

        for (Map.Entry <Integer, Integer> entry: counter.entrySet()) {
            int x = entry.getKey();
            int val = entry.getValue();
            if (k > 0 && counter.containsKey(x + k)) {
                result++;
            } else if (k == 0 && val > 1) {
                result++;
            }
        }
        System.out.println("findPairsMap:: " + result);
        return result;
    }

    public static void main(String[] args) {
        int []array = {3,1,4,1,5};
        //findPairs(array, 2);
        findPairsMap(array, 2);
    }
}
