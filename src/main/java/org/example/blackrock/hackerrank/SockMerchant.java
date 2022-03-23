package org.example.blackrock.hackerrank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SockMerchant {

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i < n; i++){
            map.put(ar.get(i), map.getOrDefault(ar.get(i), 0) + 1);
        }
        int count  = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            count += entry.getValue() / 2;
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20);
        int count  = sockMerchant(9, list);
        System.out.println("Count :: " + count);
    }
}
