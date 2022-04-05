package org.example.mustdocoding.algorithmprobs;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.time.temporal.TemporalUnit;
import java.util.*;
import java.math.*;
import java.io.*;

public class DesignHitCounter {
    Queue<Long> counter = new LinkedList<>();

    public void hit(){
        counter.add(System.currentTimeMillis());
    }

    public int getHit(long millis){
        Calendar currentTimeNow = Calendar.getInstance();

        while (!counter.isEmpty()){
            long diff = counter.peek() - System.currentTimeMillis();
            if(diff > 300){
                counter.poll();
            }
        }

        return counter.size();
    }

    public static void main(String[] args) {

    }
}
