package org.example.mustdocoding.dp;

public class CombinationSum4 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        combinationSum4(nums, target);
    }

    public static int combinationSum4(int[] nums, int target) {
        // minor optimization
        // Arrays.sort(nums);
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int combSum = 1; combSum < target + 1; ++combSum) {
            for (int num : nums) {
                if (combSum - num >= 0)
                    dp[combSum] += dp[combSum - num];
            }
        }
        return dp[target];
    }
}
