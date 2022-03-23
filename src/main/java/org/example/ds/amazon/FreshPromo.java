package org.example.ds.amazon;

import java.util.Arrays;

public class FreshPromo {

    public static void freshPromo(String[][] codeArray1, String[] cartArray1){

        String []flatArray = Arrays.stream(codeArray1)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);

        //Arrays.stream(flatArray).forEach(System.out::println);
        boolean matched = false;
        for(int i=0; i< flatArray.length;i++){
            if(flatArray[i].equals("anything")){
                continue;
            }

            if(!flatArray[i].equals(cartArray1[i])){
                matched = false;
                break;
            }else{
                matched = true;
                continue;
            }
        }

        System.out.println("Matched :: " + matched);

    }

    public static void main(String[] args) {
        String[][] codeArray1 = {{"Banana", "anything", "apple"}, {"anything", "orange", "kiwi", "apple"}};
        String[] cartArray1 = {"Banana", "mango", "apple", "cherry", "orange", "kiwi", "banana"};
        freshPromo(codeArray1, cartArray1);
    }
}
