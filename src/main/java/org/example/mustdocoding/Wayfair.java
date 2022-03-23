package org.example.mustdocoding;

import java.util.*;
import java.math.*;
import java.io.*;
import java.io.*;
import java.util.*;

/*
Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time, the ID of the user making the access, and the resource ID.

The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.

Example:
logs1 = [
    ["58523", "user_1", "resource_1"],
    ["62314", "user_2", "resource_2"],
    ["54001", "user_1", "resource_3"],
    ["200", "user_6", "resource_5"],
    ["215", "user_6", "resource_4"],
    ["54060", "user_2", "resource_3"],
    ["53760", "user_3", "resource_3"],
    ["58522", "user_22", "resource_1"],
    ["53651", "user_5", "resource_3"],
    ["2", "user_6", "resource_1"],
    ["100", "user_6", "resource_6"],
    ["400", "user_7", "resource_2"],
    ["100", "user_8", "resource_6"],
    ["54359", "user_1", "resource_3"],
]

resource 3 ->  53651 53760 54001 54060 54359


Example 2:
logs2 = [
    ["300", "user_1", "resource_3"],
    ["599", "user_1", "resource_3"],
    ["900", "user_1", "resource_3"],
    ["1199", "user_1", "resource_3"],
    ["1200", "user_1", "resource_3"],
    ["1201", "user_1", "resource_3"],
    ["1202", "user_1", "resource_3"]
]

Example 3:
logs3 = [
    ["300", "user_10", "resource_5"]
]

Write a function that takes the logs and returns the resource with the highest number of accesses in any 5 minute window, together with how many accesses it saw.

Expected Output:
most_requested_resource(logs1) # => ('resource_3', 3)
Reason: resource_3 is accessed at 53760, 54001, and 54060

most_requested_resource(logs2) # => ('resource_3', 4)
Reason: resource_3 is accessed at 1199, 1200, 1201, and 1202

most_requested_resource(logs3) # => ('resource_5', 1)
Reason: resource_5 is accessed at 300

Complexity analysis variables:

n: number of logs in the input

*/
public class Wayfair {

    public static void calculate(String[][] logs){
        Map<String, List<Long>> map = new HashMap<>();

        for(int i=0;i < logs.length; i++){
            String timeSec = logs[i][0];
            String resource = logs[i][2];

            if(!map.containsKey(resource)){
                map.put(resource, new ArrayList<>()) ;
            }
            map.get(resource).add(Long.valueOf(timeSec));
        }

        String []result=  new String[2];
        for(Map.Entry<String, List<Long>> entry : map.entrySet()){
            List<Long> list = entry.getValue();
            Collections.sort(list, Comparator.reverseOrder());
            int currentWindow  = 0;
            long max = 0;
            long currentSum = 0;
            long prevSum =  list.get(0);
            for(int i = 1; i < list.size(); i++){
                //currentSum += prevSum - list.get(i);
                //prevSum = list.get(i);
                if(list.get(currentWindow) - list.get(i) >= 300){
                    //currentSum -= list.get(currentWindow);
                    max = Math.max(max, i-currentWindow + 1);
                    currentWindow++;
                    result[0] = entry.getKey();
                    result[1] =  max + "";
                }
            }
        }

        System.out.println( result[0] + " - " +  result[1]);
    }

    public static void main(String[] argv) {

        String[][] logs1 = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                {"54359", "user_1", "resource_3"},
        };

        calculate(logs1);

        String[][] logs2 = new String[][] {
                {"300", "user_1", "resource_3"},
                {"599", "user_1", "resource_3"},
                {"900", "user_1", "resource_3"},
                {"1199", "user_1", "resource_3"},
                {"1200", "user_1", "resource_3"},
                {"1201", "user_1", "resource_3"},
                {"1202", "user_1", "resource_3"}
        };

        String[][] logs3 = new String[][] {
                {"300", "user_10", "resource_5"}
        };



    }
}
