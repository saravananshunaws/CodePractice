package org.example.meta.string;

import java.util.*;

public class WordBreak {

    // tc -> n^2, sc-> n
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        int[] visited = new int[s.length()];
        while (!q.isEmpty()) {
            int start = q.poll();
            if (visited[start] == 1) continue;
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    q.offer(end);
                    if (end == s.length())
                        return true;
                }
            }
            visited[start] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));
    }
}
