package org.example.goldman.roundone.array;

public class SearchRotatedSortedArray {
    public static void main(String[] args) {
        int nums [] = {4,5,6,7,0,1,2};
        int left = 0, right = nums.length;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[mid+1]){
                System.out.println(nums[mid + 1]);
            } else if(nums[mid - 1] < nums[mid]){
                System.out.println(nums[mid - 1]);
            }

            if(nums[0] > nums[mid]){
                right--;
            }else   if(nums[0] < nums[mid]){
                left++;
            }
        }
    }
}
