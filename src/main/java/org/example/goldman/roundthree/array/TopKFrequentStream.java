package org.example.goldman.roundthree.array;

import java.util.*;

public class TopKFrequentStream {
    public static int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            max = Math.max(max, map.get(nums[i]));
        }

        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i <= max; i++){
          list.add(new ArrayList<>());
        }

        for (Integer key : map.keySet()) {
            int freq = map.get(key);
            list.get(freq).add(key);
        }

        int[] result = new int[k];
        for(int i = list.size( ) -1 , j = 0; i > 0 && k > 0 ; i--){
            List<Integer> temp = list.get(i);
            for(Integer integer : temp){
                result[j++] = integer;
                k--;
            }
        }
        System.out.println(Arrays.toString(result));
        return null;
    }

    public static void main(String[] args) {
        int []nums = {1,1,1,2,2,3};
        int k = 2;
        topKFrequent(nums, 2);
    }
}
