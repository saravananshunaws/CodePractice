package org.example.mustdocoding.design;

import java.util.*;

public class DesignHitCounter {
    Deque<Long> hits;
    static public long minute = 1000L * 60L;

    public DesignHitCounter(){
        hits = new LinkedList<>();
    }

    public void hit(){
        hits.add(System.currentTimeMillis());
    }

    public int getHits(){
       while(hits.getFirst() > System.currentTimeMillis() - minute){
           hits.removeFirst();
       }
       return hits.size();
    }
}
