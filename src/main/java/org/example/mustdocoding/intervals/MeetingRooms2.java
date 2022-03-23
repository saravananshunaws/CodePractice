package org.example.mustdocoding.intervals;

import org.example.generic.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2 {
    public static void mergeInterval(List<Interval> list) {
        Comparator<Interval> comparator = (i1, i2) -> Integer.compare(i1.start, i2.start);
        Collections.sort(list, comparator);

        List<Interval> result = new ArrayList<>();
        int start = list.get(0).start;
        int end = list.get(0).end;

        for (int i = 1; i < list.size(); i++) {
            Interval interval = list.get(i);
            if (interval.start < end) {
                end = Math.max(interval.end, end);
            } else {
                Interval i1 = new Interval(start, end);
                result.add(i1);
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        System.out.println("Result :: " + result);
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(0, 30);
        Interval i2 = new Interval(5, 10);
        Interval i3 = new Interval(15, 20);

        List<Interval> list = new ArrayList<>();
        list.add(i1);
        list.add(i2);
        list.add(i3);

        mergeInterval(list);
    }
}
