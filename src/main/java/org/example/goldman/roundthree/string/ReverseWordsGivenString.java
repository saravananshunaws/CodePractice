package org.example.goldman.roundthree.string;

public class ReverseWordsGivenString {

    public static String reverseWord(String str){
        char []array = str.toCharArray();
        for(int i=0, j = str.length() - 1; i < str.length()  / 2; i++, j--){
            char ch = array[j];
            array[j] = array[i];
            array[i] = ch;
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        String str = "i like this program very much";
        String reversed = reverseWord(str);
        System.out.println("Reversed:: " + reversed);
        String []strArray = reversed.split(" ");
        StringBuffer buffer = new StringBuffer();
        for(int i=0; i < strArray.length; i++){
            buffer.append(reverseWord(strArray[i])).append( " ");
        }
        System.out.println("Buffer :: " + buffer.toString());
    }
}
