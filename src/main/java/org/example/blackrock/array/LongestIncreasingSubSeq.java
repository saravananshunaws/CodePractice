package org.example.blackrock.array;

public class LongestIncreasingSubSeq {
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        int max = Integer.MIN_VALUE;

        for(int i=0; i < nums.length; i++){
            int current = 0;
            for(int j = i; j < nums.length -1; j++){
                if(nums[j] < nums[j + 1]){
                    current++;
                }else{
                    break;
                }
            }
            max = Math.max(max, current);
        }
        System.out.println("Max:: " + max);
    }
}
