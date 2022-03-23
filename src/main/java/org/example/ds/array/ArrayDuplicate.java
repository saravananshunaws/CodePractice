package org.example.ds.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayDuplicate {

    public static void findDuplicates(int []nums){
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) { // seen before
                ans.add(Math.abs(num));
            }
            nums[Math.abs(num) - 1] *= -1;
        }
        ans.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        int []nums = {100, 2, 3, 5 , 4, 3};
        findDuplicates(nums);
    }
}
