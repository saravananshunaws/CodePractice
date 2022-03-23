package org.example.goldman.roundone.string;

import java.util.*;

public class TopKFrequentWords {
    static class WordFreq{
        String word;
        int freq;

        public WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }
    public static void main(String[] args) {
        String [] strings = {"i","love","leetcode","i","love","coding"};

        Comparator<WordFreq> comp = new WordFreqComparator();
        Queue<WordFreq> q = new PriorityQueue<>(comp);

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < strings.length; i++){
            map.put(strings[i], map.getOrDefault(strings[i], 0) + 1);
        }

        map.forEach((k, v) -> {
            q.offer(new WordFreq(k, v));
        });

        int k = 0;
        while(k < 2){
            System.out.println(q.poll().word);
            k++;
        }
    }

    static class WordFreqComparator implements Comparator<WordFreq>{

        @Override
        public int compare(WordFreq o1, WordFreq o2) {
           if(o1.freq == o2.freq){
               return o1.word.compareTo(o2.word);
           }else if (o1.freq < o2.freq){
               return 1;
           }else {
               return -1;
           }
        }
    }
}
