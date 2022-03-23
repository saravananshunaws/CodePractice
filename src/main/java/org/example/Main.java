package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void processRecord(long numLines , long maxValue,  List<Long> tokens){
        if(maxValue != tokens.size()){
            System.out.println("FAILURE => RECEIVED: " + tokens.size() + ", EXPECTED: " + maxValue);
        }else{
            System.out.println("SUCCESS => RECEIVED: " + tokens.size());
        }
    }


    public static void validateRecord(long numLines , List<String> tokens){
        for(int i = 0; i < numLines; i++){
            String []strs = tokens.get(i).split("\\s");
            boolean recordInvalid = false;
            List<Long> tokenList = new ArrayList<>();
            long maxValue = 0;
            for(String str : strs){
                long longValue = 0;
                try{
                    longValue = Long.parseLong(str);
                    if(longValue < 0 ){
                        System.out.println("FAILURE => WRONG INPUT (LINE " + (i + 2) +")");
                    }
                    if(maxValue < longValue){
                        maxValue = longValue;
                    }
                }catch(Exception e){
                    System.out.println("FAILURE => WRONG INPUT (LINE " + (i + 2) +")");
                    recordInvalid = true;
                    break;
                }
                tokenList.add(longValue);
            }
            if(!recordInvalid){
                processRecord(numLines, maxValue, tokenList);
            }
        }
    }

    public static void main(String args[] ) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numLines = 0 ;
        try{
            numLines = Integer.parseInt(reader.readLine());
        }catch(Exception e){
            System.out.println("FAILURE => WRONG INPUT (LINE 1)");
            return;
        }
        List<String> tokens = new ArrayList<>();

        for(int i = 0; i < numLines; i++){
            String input = reader.readLine();
            if(input == null || input.trim().length() == 0){
                System.out.println("FAILURE => WRONG INPUT (LINE " + (i + 2) +")");
            }
            tokens.add(input);
        }
        validateRecord(numLines, tokens );
    }
}
