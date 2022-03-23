package org.example.mustdocoding.heap;

import java.util.*;

public class MedianOfIntegerStream {
    private Queue<Integer> minHeap, maxHeap;

    MedianOfIntegerStream() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }

    void add(int num) {
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
    }

    double getMedian() {
        int median;
        if (minHeap.size() > maxHeap.size()) {
            median = minHeap.peek();
        } else {
            median = (minHeap.peek() + maxHeap.peek()) / 2;
        }
        return median;
    }

    public static void main(String[] args) {

        ArrayList<Integer> stream = new ArrayList<Integer>(Arrays.asList(3, 10, 5, 20, 7, 6));
        MedianOfIntegerStream medianOfIntegerStream = new MedianOfIntegerStream();
        for (Integer i : stream) {
            medianOfIntegerStream.add(i);
        }

        System.out.println(medianOfIntegerStream.getMedian());
    }
}
