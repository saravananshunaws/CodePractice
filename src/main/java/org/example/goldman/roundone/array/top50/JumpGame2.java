package org.example.goldman.roundone.array.top50;

public class JumpGame2 {

    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};
        jump(nums);
    }

    public  static int jump(int[] nums) {
        int jumps = 0, currentJumpEnd = 0, farthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentJumpEnd) {
                jumps++;
                currentJumpEnd = farthest;
            }
        }
        return jumps;
    }
}
