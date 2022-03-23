package org.example.meta;

import java.util.*;

public class AccountsMerge {
    static class DSU {
        int representative[];
        int size[];

        DSU(int sz) {
            representative = new int[sz];
            size = new int[sz];
            for (int i = 0; i < sz; ++i) {
                representative[i] = i;
                size[i] = 1;
            }
        }

        // Finds the representative of group x
        public int findRepresentative(int x) {
            if (x == representative[x]) {
                return x;
            }
            return representative[x] = findRepresentative(representative[x]);
        }

        public void unionBySize(int a, int b) {
            int representativeA = findRepresentative(a);
            int representativeB = findRepresentative(b);

            if (representativeA == representativeB) {
                return;
            }
            if (size[representativeA] >= size[representativeB]) {
                size[representativeA] += size[representativeB];
                representative[representativeB] = representativeA;
            } else {
                size[representativeB] += size[representativeA];
                representative[representativeA] = representativeB;
            }
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accountList) {
        int accountListSize = accountList.size();
        DSU dsu = new DSU(accountListSize);

        // Maps email to their component index
        Map<String, Integer> emailGroup = new HashMap<>();

        for (int i = 0; i < accountListSize; i++) {
            int accountSize = accountList.get(i).size();

            for (int j = 1; j < accountSize; j++) {
                String email = accountList.get(i).get(j);
                String accountName = accountList.get(i).get(0);
                if (!emailGroup.containsKey(email)) {
                    emailGroup.put(email, i);
                } else {
                    dsu.unionBySize(i, emailGroup.get(email));
                }
            }
        }

        Map<Integer, List<String>> components = new HashMap<Integer, List<String>>();
        for (String email : emailGroup.keySet()) {
            int group = emailGroup.get(email);
            int groupRep = dsu.findRepresentative(group);

            if (!components.containsKey(groupRep)) {
                components.put(groupRep, new ArrayList<String>());
            }

            components.get(groupRep).add(email);
        }

        // Sort the components and add the account name
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (int group : components.keySet()) {
            List<String> component = components.get(group);
            Collections.sort(component);
            component.add(0, accountList.get(group).get(0));
            mergedAccounts.add(component);
        }

        return mergedAccounts;
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

        accountsMerge(outer);
    }


}
