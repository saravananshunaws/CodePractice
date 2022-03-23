package org.example.goldman.roundthree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    static class Cache{
        public String key;
        public Object value;
        public long expirationTime;

        public Cache(String key, Object value, long expirationTime){
            this.key = key;
            this.value = value;
            this.expirationTime = expirationTime;
        }
    }

    static Deque<Cache> queue = new ArrayDeque<>();
    static Map<String, Cache> map = new LinkedHashMap<>();
    static int CAPACITY = 16;

    public static void put(String key, Object value){
        if(map.containsKey(key)){
           Cache cache = map.get(key);

           queue.remove(cache);
           map.remove(cache);
        }

        if(map.size() > CAPACITY){
            queue.removeLast();
            map.remove(map.get(key));
        }

        Cache cache = new Cache(key, value, System.currentTimeMillis());
        queue.addFirst(cache);
        map.put(key, cache);
    }

    public static Object get(String key){
        if(map.containsKey(key)){
           Cache cache = map.get(key);
           queue.remove(cache);
           queue.addFirst(cache);
        }

        return null;
    }
}
