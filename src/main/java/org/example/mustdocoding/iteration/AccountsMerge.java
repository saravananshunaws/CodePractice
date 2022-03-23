package org.example.mustdocoding.iteration;

import java.util.*;

public class AccountsMerge {

    static class UnionFind{
        int []parent;
        int []size;
        public UnionFind(int x){
            parent = new int[x];
            size = new int[x];

            for (int i = 0; i < x; i++) {
                parent[x] = i;
                size[x] = 1;
            }
        }

        public int find(int x){
            if(x == parent[x]){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
               if(size[rootX] > size[rootY]){
                   parent[rootY] = rootX;
               } else if(size[rootX] < size[rootY]){
                   parent[rootX] = rootY;
               } else{
                   parent[rootY] = rootX;
                   size[rootX] += 1;
               }
            }
        }

    }

    public static void accountsMerge(List<List<String>> accountsList){
        UnionFind unionFind = new UnionFind(accountsList.size());
        Map<String, Integer> emailGroup = new HashMap<>();
        for (int i = 0; i < accountsList.size(); i++) {
           List<String> accounts = accountsList.get(i);
            for (int j = 0; j < accounts.size(); j++) {
                String name = accounts.get(0);
                String email = accounts.get(i);
                if(!emailGroup.containsKey(email)){
                    emailGroup.put(email, i);
                }else{
                   unionFind.union(i, emailGroup.get(email));
                }
            }
        }

        for ( Map.Entry<String, Integer> entry : emailGroup.entrySet()) {
            int group = unionFind.find(entry.getValue());
        }
    }

    public static void main(String[] args) {
        String[][] accounts = {{"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"John", "johnsmith@mail.com", "john00@mail.com"},
                {"Mary", "mary@mail.com"}, {"John", "johnnybravo@mail.com"}};
        List<List<String>> accountsList = new ArrayList<>();
        for (String[] account : accounts) {
            List<String> tempList = new ArrayList<>(Arrays.asList(account));
            accountsList.add(tempList);
        }
    }
}
