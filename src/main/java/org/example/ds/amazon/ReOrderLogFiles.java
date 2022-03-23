package org.example.ds.amazon;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReOrderLogFiles {



    public static void main(String[] args) {
        String []log = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};

        Comparator<String> comparator = (String S1, String  S2) -> {
            String str1 = S1.substring(S1.indexOf(" ") + 1);
            String str2 = S2.substring(S2.indexOf(" ") + 1);
            return str1.compareTo(str2);
        };

        Predicate<String> predicate = (String S1) -> {
            String str1 = S1.substring(S1.indexOf(" ") + 1);
            String trimmed = str1.replaceAll("\\s", "");
            if(trimmed.matches("[0-9]+"))
                 return true;
            else
                return false;
        };

        Predicate<String> wordspredicate = (String S1) -> {
            String str1 = S1.substring(S1.indexOf(" ") + 1);
            String trimmed = str1.replaceAll("\\s", "");
            if(trimmed.matches("[a-zA-Z]+"))
                return true;
            else
                return false;
        };

        List<String> numbers = Arrays.stream(log).filter(predicate).collect(Collectors.toList());
        System.out.println(numbers);

        List<String> words = Arrays.stream(log).filter(wordspredicate).sorted(comparator).collect(Collectors.toList());
        System.out.println(words);

        List<String> newList = new ArrayList<String>(words);
        newList.addAll(numbers);
        System.out.println(newList);
        newList.stream().toArray(String[]::new);
    }
}
