package org.example.goldman.roundtwo;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheObject {
    int key;
    String value;
    long expires;

    CacheObject(int key, String value, long expires) {
        this.key = key;
        this.value = value;
        this.expires = expires;
    }
}

public class LRUCache {
    static Deque<Integer> q = new LinkedList<>();
    static Map<Integer, CacheObject> map = new HashMap<>();
    int CACHE_CAPACITY = 4;

    public String getElementFromCache(int key) {
        if (map.containsKey(key)) {
            CacheObject current = map.get(key);
            if (System.currentTimeMillis() > current.expires) {
                q.remove(current.key);
                return null;
            }
            q.remove(current.key);
            q.addFirst(current.key);
            return current.value;
        }
        return "No such element present in Cache";
    }

    public void putElementInCache(int key, String value, long validTime) {
        if (map.containsKey(key)) {
            CacheObject curr = map.get(key);
            q.remove(curr.key);
        } else {
            if (q.size() == CACHE_CAPACITY) {
                int temp = q.removeLast();
                map.remove(temp);
            }
        }
        long expires = 0;
        if (validTime > 0) {
            expires = System.currentTimeMillis() + validTime;
        } else {
            expires = Long.MAX_VALUE;
        }
        CacheObject newItem = new CacheObject(key, value, expires);
        q.addFirst(newItem.key);
        map.put(key, newItem);
    }

    // Driver Code to test above methods.
    public static void main(String[] args) {

        LRUCache cache = new LRUCache();
        cache.putElementInCache(1, "Product-A-Name", 100);
        cache.putElementInCache(2, "Product-B-Name", 100);
        cache.putElementInCache(3, "Product-C-Name", 100);
        cache.putElementInCache(4, "Product-D-Name", 100);

        // We get 2 from cache
        System.out.println(cache.getElementFromCache(2));
        System.out.println();

        // We print our queue and see 2 will be at front of cache
        System.out.println(q);
        System.out.println();

        //Element 5 is not present in Cache
        System.out.println(cache.getElementFromCache(5));
        cache.putElementInCache(5, "Product-E-Name", 100);
        System.out.println();

        //Now after adding 5 in cache it will be at front and 1 is deleted.
        System.out.println(q);
        System.out.println();

    }

}