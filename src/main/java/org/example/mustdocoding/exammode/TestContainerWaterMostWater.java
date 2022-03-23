package org.example.mustdocoding.exammode;

public class TestContainerWaterMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int n = height.length;
        int left = 0, right = n - 1;
        int maxWater = 0;
        while (left < right) {
            maxWater = Math.max(Math.min(height[right], height[left]) * (right - left), maxWater);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println("Max Water :: " + maxWater);
    }
}
