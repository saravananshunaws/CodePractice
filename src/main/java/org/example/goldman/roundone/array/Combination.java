package org.example.goldman.roundone.array;

import java.util.*;

public class Combination {
    public static void backtrack(int remain, LinkedList<Integer> comb,
                                 int start, int[] candidates, List<List<Integer>> results) {

        if (remain == 0) {
            // make a deep copy of the current combination
            results.add(new ArrayList<Integer>(comb));
            return;
        } else if (remain < 0) {
            // exceed the scope, stop exploration.
            return;
        }

        for (int i = start; i < candidates.length; ++i) {
            // add the number into the combination
            comb.add(candidates[i]);
            backtrack(remain - candidates[i], comb, i, candidates, results);
            // backtrack, remove the number from the combination
            comb.removeLast();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        LinkedList<Integer> comb = new LinkedList<Integer>();

        backtrack(target, comb, 0, candidates, results);
        return results;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        combinationSum(candidates, 7);
    }
}
