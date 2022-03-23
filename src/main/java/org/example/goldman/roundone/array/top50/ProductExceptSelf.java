package org.example.goldman.roundone.array.top50;

public class ProductExceptSelf {

    public static void main(String[] args) {
        int  nums[] = {1,2,3,4};
        productExceptSelf(nums);
    }

    public  static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++)
            result[i] = result[i - 1] * nums[i - 1];

        int right = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
}
