package org.example.goldman.roundone.array;

import java.util.*;

public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < intervals.size(); i++){
            Interval interval = intervals.get(i);
            if(interval.start < end){
                end = Math.max(interval.end, end);
            }else{
                mergedIntervals.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        mergedIntervals.add(new Interval(start, end));
        System.out.println(mergedIntervals);
        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
