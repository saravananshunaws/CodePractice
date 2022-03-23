package org.example.goldman.roundone.string.top50;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        String str = "aabbcc";
        char []array = str.toCharArray();
        int groupCount =0, left =0;
        for(int i=0; i < array.length; i++){
            groupCount = 1;
            int j = left;
            while(array[j] == array[j + 1]){
                groupCount++;
                j++;
            }

            char ch = array[left];
            array[left++] = ch;
            if(groupCount > 1){
                char []arr1 = String.valueOf(groupCount).toCharArray();
                for(char ch1: arr1){
                  array[left] = ch1;
                  left++;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }
}
