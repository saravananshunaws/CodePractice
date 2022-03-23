package org.example.blackrock.string;

public class StringCompression {
    public static void main(String[] args) {
        String s = "aabbcc";
        int slow= 0, fast = 0, groupCount = 0;
        char []result = new char[s.length()];
        while(slow < s.length()){
            groupCount = 1;
            while(fast < s.length() - 1 && s.charAt(fast) == s.charAt(fast + 1)){
                groupCount++;
                fast++;
            }
            result[slow] = s.charAt(fast);
            slow++;
            fast++;
            if(groupCount > 1){
                for(char ch : String.valueOf(groupCount).toCharArray()){
                    result[slow] = ch;
                    slow++;
                }
            }
            System.out.println(String.valueOf(result));
        }
        System.out.println(String.valueOf(result));
    }
}
