package org.example.mustdocoding.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
    public static int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        PriorityQueue<Integer> allocator = new PriorityQueue<>(intervals.length, (a, b) -> a - b);
        Arrays.sort(intervals,(a, b) -> a[0] - b[0]);

        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }

    public static void main(String[] args) {
        int [][]intervals = {{0,30},{5,10}, {15,20}};
        System.out.println(minMeetingRooms(intervals));
    }
}
