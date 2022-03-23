package org.example.blackrock.array;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int mid = 0, start = 0, end = nums.length - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                System.out.println("Index :: " + mid);
                return;
            } else {
                if (nums[mid] >= nums[start]) {
                    if(target > nums[start] && target < nums[mid]) {
                        end = mid -1;
                    }else{
                        start = mid + 1;
                    }
                } else {
                    if(target > nums[mid] && target < nums[end]) {
                        start = mid + 1;
                    }else{
                        end = mid -1;
                    }
                }
            }
        }
    }
}
