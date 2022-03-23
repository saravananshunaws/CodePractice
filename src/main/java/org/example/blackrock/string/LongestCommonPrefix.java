package org.example.blackrock.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("flower","flow","flight");
        Collections.sort(list);
        System.out.println(list);
        int index = 1;
        String append = "";
        while(true){
            boolean match = true;
            append = list.get(0).substring(0, index );
            for(String str: list) {
                if (str.indexOf(append) != -1){
                    continue;
                }else{
                    match = false;
                    break;
                }
            }
            if(!match)
                break;
            index++;
        }

        System.out.println(list.get(0).substring(0, index -1));
    }
}
