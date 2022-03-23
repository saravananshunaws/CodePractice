package org.example.meta.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDiffPairs {
    public static void usingBinarySearch(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = 1, result = 0;
        while (left < nums.length && right < nums.length) {
            if (left == right || nums[right] - nums[left] < k) {
                right++;
            } else if (nums[right] - nums[left] > k) {
                left++;
            } else {
                result++;
                left++;
                while (left < nums.length && nums[left] == nums[left - 1]) {
                    left++;
                }
            }
        }
        System.out.println("Result :: " + result);
    }

    public static void usingMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(k >0 && map.containsKey(k + key)){
                result++;
            } else if(k==0 && map.containsKey(value)){
                result++;
            }
        }
        System.out.println("Result :: " + result);
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int k = 2;
        usingBinarySearch(nums, k);
        usingMap(nums, k);
    }
}
