package org.example.ds.amazon;

import java.util.*;

public class KFrequentNumbers {
    static void print_N_mostFrequentNumber(int[] arr, int n, int k) {

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mp.entrySet());

        // Sort the list
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o2.getKey() - o1.getKey();
            else
                return o2.getValue() - o1.getValue();
        });

        for (int i = 0; i < k; i++)
            System.out.println(list.get(i).getKey());
    }

    static void print_N_mostFrequentString(String[] arr, int n, int k) {

        Map<String, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new ArrayList<>(mp.entrySet());

        // Sort the list
        Collections.sort(list, (o1, o2) -> {
            if (o1.getValue() == o2.getValue())
                return o2.getKey().compareTo(o1.getKey());
            else
                return -1;
        });

        for (int i = 0; i < n; i++)
            System.out.println(list.get(i).getKey());
    }

    // Driver Code
    public static void main(String[] args) {
        int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
        int n = arr.length;
        int k = 2;

        //print_N_mostFrequentNumber(arr, n, k);


        String strArray[] = {"i","love","leetcode","i","love","coding"};
        //n = strArray.length;
        //print_N_mostFrequentString(strArray, n, 2);
        System.out.println(topKFrequent(strArray, 2));
    }

    public static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for(String word : words) {
            map.put(word, 1 + map.getOrDefault(word, 0));
        }

        PriorityQueue<WordFreq> pq = new PriorityQueue<WordFreq>(new WordFreqComparator());

        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            WordFreq wordFreq = new WordFreq(entry.getKey(), entry.getValue());
            pq.add(wordFreq);
        }

        List<String> results = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            String word = pq.remove().getWord(); //log(n)
            results.add(word);
        }
        return results;
    }
}

class WordFreq {
    String word;
    int frequency;
    WordFreq(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }
    public int getFrequency() {
        return frequency;
    }
    public String getWord() {
        return word;
    }
}

class WordFreqComparator implements Comparator<WordFreq> {
    public int compare(WordFreq w1, WordFreq w2) {
        if(w1.getFrequency() < w2.getFrequency())
            return 1;
        else if(w1.getFrequency() > w2.getFrequency())
            return -1;
        else {
            if(w1.getWord().compareTo(w2.getWord()) < 0)
                return -1;
            return 1;
        }
    }
}