package org.example.mustdocoding.algorithmprobs;

import java.util.*;

public class UserWebsiteVisitPattern {

    public static void main(String[] args) {
        String[]username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] timestamp = {1,2,3,4,5,6,7,8,9,10} ;
        String[] website = {"home","about","career","home","cart","maps","home","home","about","career"};
        System.out.println(mostVisitedPattern(username, timestamp, website));
    }

    public static List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        int n = username.length;
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.putIfAbsent(username[i], new TreeMap<>());
            map.get(username[i]).put(timestamp[i], website[i]);
        }

        TreeMap<String, Integer> seqMap = new TreeMap<>();
        for (TreeMap<Integer, String> treeMap : map.values()) {
            List<String> list = new ArrayList<>();

            for (String web : treeMap.values())
                list.add(web);
            Set<String> seqs = generate3Seq(list);
            for (String seq : seqs)
                seqMap.put(seq, seqMap.getOrDefault(seq, 0) + 1);
        }

        int maxCnt = 0;
        String maxSeq = "";

        for (String key : seqMap.keySet()) {
            int cnt = seqMap.get(key);

            if (cnt > maxCnt) {
                maxCnt = cnt;
                maxSeq = key;
            }
        }

        return Arrays.asList(maxSeq.split(" "));
    }

    // Generate 3-length subsequence
    private static Set<String> generate3Seq(List<String> websitesList) {
        Set<String> setOfListSeq = new HashSet<>();

        for (int i = 0; i < websitesList.size(); i++) {
            for (int j = i + 1; j < websitesList.size(); j++) {
                for (int k = j + 1; k < websitesList.size(); k++) {
                    StringBuilder sb = new StringBuilder();

                    sb.append(websitesList.get(i)).append(" ");
                    sb.append(websitesList.get(j)).append(" ");
                    sb.append(websitesList.get(k));

                    setOfListSeq.add(sb.toString());
                }
            }
        }

        return setOfListSeq;
    }
}
