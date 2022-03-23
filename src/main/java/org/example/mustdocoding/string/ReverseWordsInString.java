package org.example.mustdocoding.string;

public class ReverseWordsInString {

    public static String reverse(String s){
        char []array = s.toCharArray();
        for(int i=0, j = s.length() -1; i < array.length / 2; i++, j--){
            char temp = array[j];
            array[j] = array[i];
            array[i] = temp;
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        String reverse = reverse(s);
        System.out.println("Reverse1:: " + reverse);
        String []strs = reverse.split("\\s");
        StringBuffer buffer = new StringBuffer();
        for(String str: strs){
            buffer.append(reverse(str)).append(" ");
        }

        System.out.println("Result:: " + buffer.toString());
    }
}
