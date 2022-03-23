package org.example.blackrock.exammode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class TextFormtting {

    static class Interval{
        long startIndex;
        long endIndex;

        public Interval(long startIndex , long endIndex){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int startingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> starting = IntStream.range(0, startingCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int endingCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ending = IntStream.range(0, endingCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int styleCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Character> style = IntStream.range(0, styleCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(e -> e.charAt(0))
                .collect(toList());
        /*List<Integer> starting = new ArrayList<>();
        starting.add(1); starting.add(3);starting.add(9);starting.add(5);starting.add(9);
        List<Integer> ending = new ArrayList<>();
        ending.add(5); ending.add(8);ending.add(10);ending.add(6);ending.add(10);
        List<Character> style = new ArrayList<>();
        style.add('b');style.add('i');style.add('i');style.add('i');style.add('u');*/

        int startSize = starting.size();
        int endSize = ending.size();
        int styleSize = style.size();

        if (startSize != endSize && endSize != styleSize && startSize != styleSize) {
            System.out.println("Size not matched:: ");
        }

        Map<Character, List<Interval>> styleMap = new LinkedHashMap<>();
        for (int i = 0; i < style.size(); i++) {
            Character c = style.get(i);
            long startIndex = starting.get(i);
            long endIndex = ending.get(i);
            if (!styleMap.containsKey(c)) {
                styleMap.put(c, new ArrayList<>());
            }
            styleMap.get(c).add(new Interval(startIndex, endIndex));
        }

        long result = 0;

        Map<Character, List<Interval>> styleMergedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, List<Interval>> entry : styleMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                styleMergedMap.put(entry.getKey(), merge(entry.getValue()));
            } else {
                styleMergedMap.put(entry.getKey(), entry.getValue());
            }
        }

        Map<String, String> resultMap = new LinkedHashMap<>();
        int selectIndex = 0, applyIndex = 0;
        Map<String, long []> selected = new HashMap<>();
        for (Map.Entry<Character, List<Interval>> entry : styleMergedMap.entrySet()) {
            List<Interval> list = entry.getValue();
            Character styleChar = entry.getKey();
            result +=  (list.size() * 2);
            for (int i = 0; i < list.size(); i++) {
                long startIndex = list.get(i).startIndex;
                long endIndex = list.get(i).endIndex;

                //int key = Objects.hash(startIndex, endIndex);
                String key = startIndex + "-" + endIndex;
                //System.out.println("Key:: " + key);
                long [] value = {startIndex, endIndex};
                if (selected.get(key) == null) {
                    selected.put(key, value);
                    //selectIndex++;
                } else {
                    //result--;
                }
                //applyIndex++;
                String s = resultMap.get(key);
                String insertStyleChar = String.valueOf(styleChar);
                if (s == null) {
                    resultMap.put(key, insertStyleChar);
                } else {
                    if (s.indexOf(insertStyleChar) != -1) {
                        //result--;
                       break;
                    } else {
                        resultMap.put(key, s + insertStyleChar);
                    }
                }
            }
        }
        System.out.println("Result :: " + result);

        System.out.println("selectIndex :: " + selectIndex);
        System.out.println("applyIndex :: " + applyIndex);
        System.out.println("Combined :: " + (selectIndex + applyIndex));

    }
    static int mergeCount = 0;
    public static List<Interval> merge(List<Interval> intervals) {

        Collections.sort(intervals, Comparator.comparingLong(l -> l.startIndex));

        long start = intervals.get(0).startIndex;
        long end = intervals.get(0).endIndex;
        List<Interval> result = new ArrayList<>();
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.startIndex == start && interval.endIndex == end) {
                result.add(new Interval(start, end));
            } else if(interval.startIndex > start && interval.endIndex < end){
                start = interval.startIndex;
                end = interval.endIndex;
                result.add(new Interval(start, end));
            }
            /*else if (interval.startIndex <= end) {
                end = Math.max(end, interval.endIndex);
            } */
            else{
                result.add(new Interval(start, end));
                start = interval.startIndex;
                end = interval.endIndex;
            }
        }
        //result.add(new Interval(start, end));
        return result;
    }



    public static boolean checkOverlappingIndex(int startIndex, int endIndex, Character styleChar, List<Interval> list) {
        for(Interval interval : list){
          if(startIndex >= interval.startIndex && endIndex <= interval.endIndex){
              return true;
          }
        }
        return false;
    }


    public static void read() {
       /* int max = 0;
        for(int i= 0; i < starting.size(); i++){
            if(max< ending.get(i)){
                max = ending.get(i);
            }
        }

        int selectOper= 0, styleOper = 0;

        Map<Integer, int[]> map =  new HashMap<>();
        Map<Integer, Pair> pairMap =  new HashMap<>();
        for(int i = 0; i < starting.size(); i++){
            int startIndex = starting.get(i);
            int endIndex = ending.get(i);
            Character styleChar = style.get(i);

            int hash = Objects.hash(startIndex, endIndex);

            if(!map.containsKey(hash)){
                map.put(hash, new int[]{startIndex, endIndex});
                selectOper++;
            }else {
                if (endIndex > map.get(startIndex)[1]) {
                    selectOper++;
                }
            }

            styleOper++;

            Pair p = pairMap.get(hash);
            String s =String.valueOf(styleChar);
            if(p == null){
                p = new Pair(startIndex, endIndex, String.valueOf(styleChar));
                pairMap.put(hash, p);
            } else{
                String tempStyle = p.styledChars;
                if(!tempStyle.contains(styleChar + "")){
                    p.append(String.valueOf(styleChar));
                }else {
                    styleOper--;
                    break;
                }
            }
           *//* String tempStyle = strmap.get(startIndex + endIndex);
            for(int j = startIndex ; j <= endIndex; j++){
                if(!tempStyle.contains(styleChar + "")){
                    strmap.put(startIndex + endIndex, tempStyle + styleChar);
                }else {
                    styleOper--;
                    break;
                }
            }*//*
        }

        for(Map.Entry<Integer, Pair> entry : pairMap.entrySet()){
            System.out.println(entry.getValue() + " ");
        }
        System.out.println();

        System.out.println(selectOper);
        System.out.println(styleOper);*/
    }
}

