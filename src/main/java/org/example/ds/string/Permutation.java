package org.example.ds.string;

import java.util.*;

public class Permutation {

    public static void permutations(String str)
    {
        // base case
        if (str == null || str.length() == 0) {
            return;
        }

        // create an empty `ArrayList` to store (partial) permutations
        // and initialize it with the first character of the string
        List<String> partial = new ArrayList<>();
        partial.add(String.valueOf(str.charAt(0)));

        // do for every character of the specified string
        for (int i = 1; i < str.length(); i++)
        {
            // consider previously constructed partial permutation one by one
            // (iterate backward to avoid `ConcurrentModificationException`)
            for (int j = partial.size() - 1; j >= 0; j--)
            {
                // remove current partial permutation from the list
                String s = partial.remove(j);

                // Insert the next character of the specified string into all
                // possible positions of current partial permutation. Then
                // insert each of these newly constructed strings into the list.

                for (int k = 0; k <= s.length(); k++)
                {
                    // Please note that string concatenation is costly in Java.
                    // Use StringBuilder instead.
                    String a = s.substring(0, k);
                    String b =  str.charAt(i) + "";
                    String c =  s.substring(k);
                    partial.add(a + b + c);
                }
            }
        }

        System.out.println(partial);
    }

    public static void main(String[] args) {
        permutations("ABC");
    }
}
