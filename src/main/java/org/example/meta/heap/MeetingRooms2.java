package org.example.meta.heap;

import java.util.*;
import java.math.*;
import java.io.*;

public class MeetingRooms2 {
    public static void meetingRooms2(int [][]intervals ){
        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });
        allocator.add(intervals[0][1]);
        int size = allocator.size();
        for (int i = 0; i < size; i++) {
            System.out.println(allocator.poll());
        }
    }

    public static void main(String[] args) {
        int [][]intervals = {{0,30},{5,10},{15,20}};
        meetingRooms2(intervals);
    }
}
