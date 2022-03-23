package org.example.blackrock.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int []nums = {1,8,6,2,5,4,8,3,7};
        int left = 0, right = nums.length -1, max = Integer.MIN_VALUE;
        while(left <= right){
            max = Math.max(max, Math.min(nums[left], nums[right]) * (right - left));
            if(left < right){
                left++;
            }else{
                right--;
            }
        }
        System.out.println("Max :: " + max);
    }
}
