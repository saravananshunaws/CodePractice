package org.example.studyplan.DS1;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean ContainsDuplicate(int [] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if( map.get(nums[i]) > 1){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int []nums = {1,2,3,1, 3};
        System.out.println(ContainsDuplicate(nums));
    }
}
