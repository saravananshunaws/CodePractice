package org.example.studyplan.DS1;

public class MaxSubArray {
    public static int ContainsDuplicate(int [] nums){
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        System.out.println("Max :: " + maxSubarray);
        return maxSubarray;
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    System.out.println(nums[i] + "-" + nums[j]);
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        ContainsDuplicate(nums);
        int []nums1 = {1,2,30,4,5,6,7,8};
        twoSum(nums1, 3);
    }
}
