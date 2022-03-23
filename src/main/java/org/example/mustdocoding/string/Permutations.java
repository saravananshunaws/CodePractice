package org.example.mustdocoding.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public static void permutation( List<Character> input, int n, List<List<Character>> result, int index) {

        if(index == n){
            result.add(new ArrayList<>(input));
        }

        for(int i= index; i < n ; i++){
            Collections.swap(input, index, i);
            permutation(input, n, result, index + 1);
            Collections.swap(input, index, i);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        List<Character> input = str.chars().mapToObj(x -> (char)x).collect(Collectors.toList());
        List<List<Character>> result = new ArrayList<>();
        permutation(input, input.size(), result, 0);
        System.out.println("Result :: " + result);
    }
}
