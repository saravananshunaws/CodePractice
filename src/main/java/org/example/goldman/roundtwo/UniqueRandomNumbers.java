package org.example.goldman.roundtwo;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class UniqueRandomNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> Integer.compare(b, a));

        System.out.println( String.format("%.2fM", (1000000 * 100)/ 1000000.0));

        for (int i=1; i<(1000001 * 10); i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);

        PriorityQueue<Integer> q1 = new PriorityQueue<>((a,b) -> Integer.compare(a, b));

        for (int i=0; i < list.size(); i++) {
            q1.add(list.get(i));
        }

        System.out.println("Top 10:: " );
        for (int i=0; i < 10; i++) {
            System.out.println(q1.poll());
        }
        System.out.println();

       /* System.out.println("Bottom 10:: " );
        for (int i=0; i < list.size(); i++) {
            q.add(list.get(i));
        }

        for (int i=0; i < 10; i++) {
            System.out.println(q.poll());
        }*/


    }
}
