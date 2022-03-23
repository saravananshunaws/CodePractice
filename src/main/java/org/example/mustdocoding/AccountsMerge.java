package org.example.mustdocoding;

import java.util.*;

public class AccountsMerge {

    static class UnionFind {
        int[] parent; // contains parent

        UnionFind(int n) { // initialize parent
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        void union(int a, int b) {
            int x = find(a); // find a
            int y = find(b);// find b
            parent[x] = parent[y]; // set parent of x as parent of y
        }

        int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size(); // size of list
        UnionFind uf = new UnionFind(n); // initialize union class with n size
        Map<String, Integer> map = new HashMap<>();  //email to id mapper
        for (int i = 0; i < accounts.size(); i++) {
            // creating hashmap from every email to first account id
            // and build union set of accounts based on shared mails
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j); // get the mail for every index except 0 as 0 index contains name
                if (map.containsKey(email)) { // map contains key so update parent/connect them
                    uf.union(map.get(email), i);
                } else {
                    map.put(email, i);// put email to parent index
                }
            }
        }
        Map<Integer, List<String>> setToEmail = new HashMap<>();// mapping ids to list of emails
        for (Map.Entry<String, Integer> p : map.entrySet()) {
            int id = uf.find(p.getValue());
            setToEmail.putIfAbsent(id, new ArrayList<>());
            setToEmail.get(id).add(p.getKey());
        }
        List<List<String>> res = new ArrayList<>();
        // create result list from ids to list of mail map
        for (Map.Entry<Integer, List<String>> p : setToEmail.entrySet()) {
            String name = accounts.get(p.getKey()).get(0);
            List<String> nlist = p.getValue();
            Collections.sort(nlist);
            List<String> list = new ArrayList<>();
            list.add(name);
            list.addAll(nlist);
            res.add(list);
        }
        return res;
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
