package org.example.meta.array;

public class SearchFirstAndLastPositionK {

    public static int searchFirstAndLastPositionK(int[] nums, int target, boolean leftPass) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (leftPass) {
                    while (mid > 0 && nums[mid] == nums[mid - 1]) {
                        mid--;
                    }
                    return mid;
                } else {
                    while (mid < nums.length -1 && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    return mid;
                }
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int left  = searchFirstAndLastPositionK(nums, target, true);
        int right  = searchFirstAndLastPositionK(nums, target, false);
        System.out.println(left + "-" + right);
    }
}
