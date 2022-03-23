package org.example.mustdocoding.exammode;

import java.util.*;

public class TestAccountsMerge {

    static class UnionFind {
        int[] root;
        int[] rank;

        public UnionFind(int x) {
            root = new int[x];
            rank = new int[x];
            for (int i = 0; i < x; i++) {
              rank[i] = 1;
            }
        }

        public int find(int x){
            if(x == root[x]){
                return x;
            }

            return root[x] = find(x);
        }
        public void union(int a, int b){
            int x = find(a);
            int y = find(b);

            root[y] = root[x];
        }
    }

    public static Map<String, List<String>> accountsMerge(List<List<String>> accounts) {

        int size = accounts.size();
        Map<String, Integer> groupedMap = new HashMap<>();
        UnionFind unionFind = new UnionFind(size);
        for (int i = 0; i < size; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String name = account.get(0);
                String email =  account.get(j);
                if(!groupedMap.containsKey(email)){
                    groupedMap.put(email, i);
                }else{
                  unionFind.union(groupedMap.get(i), i);
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        List<String> inner = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> inner1 = Arrays.asList("Mary", "mary@mail.com");
        List<String> inner2 = Arrays.asList("John", "johnsmith@mail.com");
        List<String> inner3 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");

        List<List<String>> outer = new ArrayList<>();
        outer.add(inner);
        outer.add(inner1);
        outer.add(inner2);
        outer.add(inner3);

        System.out.println(accountsMerge(outer));
    }
}
