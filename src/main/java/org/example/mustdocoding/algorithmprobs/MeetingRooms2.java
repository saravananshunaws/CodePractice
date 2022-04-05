package org.example.mustdocoding.algorithmprobs;

import java.util.*;
import java.math.*;
import java.io.*;

public class MeetingRooms2 {
    public static void main(String[] args) {
        mergeIntervals();
    }

    public static void meetingRooms2(){
        int [][]intervals = {{0,30}, {5,10}, {15,20}};
        Comparator<int[]> comparator = (a, b) -> Integer.compare(a[0], b[0]);
        Arrays.sort(intervals, comparator);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(intervals[0][1]);

        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][1] > pq.peek()){
                pq.poll();
            }

            pq.add(intervals[i][1]);
        }

        System.out.println("Rooms Required :: " + pq.size());
    }

    static class Interval{
        public int startTime;
        public int endTime;

        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    public static void mergeIntervals(){
        int [][]intervals = {{1,3}, {2,6}, {8,10},{15,18}};
        Comparator<int[]> comparator = (a, b) -> Integer.compare(a[0], b[0]);
        Arrays.sort(intervals, comparator);
        Interval interval = new Interval(intervals[0][0], intervals[0][1]);
        int start = interval.startTime;
        int end = interval.endTime;
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < interval.endTime){
                end = intervals[i][1];
            }else{
                result.add(new Interval(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        result.add(new Interval(start, end));

        System.out.println(result);
    }

}
