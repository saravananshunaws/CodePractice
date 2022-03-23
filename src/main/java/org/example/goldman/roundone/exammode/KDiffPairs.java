package org.example.goldman.roundone.exammode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class KDiffPairs {

    public static void findPairsMap(int []array, int k){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i < array.length; i++){
            map.put(array[i], map.getOrDefault(array[i], 0 ) + 1);
        }

      AtomicInteger count = new AtomicInteger();
      map.forEach((key, val) -> {
          if(k >0 && map.containsKey(key + k)){
              count.getAndIncrement();
          }
          if(k ==0 && val > 1){
              count.getAndIncrement();
          }
      });
        System.out.println("Count:: " + count);
    }

    public static void main(String[] args) {
        int []array = {3,1,4,1,5};
        //findPairs(array, 2);
        findPairsMap(array, 2);
    }
}
