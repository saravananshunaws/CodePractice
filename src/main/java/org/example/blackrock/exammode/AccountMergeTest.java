package org.example.blackrock.exammode;

import java.util.*;
import java.math.*;
import java.io.*;

public class AccountMergeTest {

    static class UnionFind{
        int []parent;

        public UnionFind(int n){
            parent = new int[n];
            for(int i=0; i < n; i++){
                parent[i] = i;
            }
        }

        public void union(int x, int y){
            int i = find(x);
            int j = find(y);
            parent[i] = parent[j];
        }

        public int find(int x){
            if(x == parent[x]){
                return x;
            }

            return parent[x] = find(parent[x]);
        }

    }

    public static void  accountsMerge(List<List<String>> accounts){
        Map<String, Integer> emailToId = new HashMap<>();
        UnionFind unionFind = new UnionFind(accounts.size());
        for(int i=0; i < accounts.size(); i++){
            List<String> list = accounts.get(i);
            for(int j=1; j < list.size(); j++){
                String email = list.get(j);
                if(emailToId.containsKey(email)){
                    unionFind.union(emailToId.get(email), i);
                }else{
                    emailToId.put(email, i);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<String> inner = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> inner1 = Arrays.asList("Mary", "mary@mail.com");
        List<String> inner2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> inner3 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");

        List<List<String>> outer = new ArrayList<>();
        outer.add(inner);
        outer.add(inner1);
        outer.add(inner2);
        outer.add(inner3);

        accountsMerge(outer);
    }
}
