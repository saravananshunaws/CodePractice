package org.example.blackrock.array;

public class ReverseInt {
    public static void main(String[] args) {
        int x = 123;
        int rem = x;
        int reversed = 0;
        while(true){
            rem = x % 10;
            reversed = (reversed * 10) + (rem);
            x = x / 10;

            if(x ==0){
                break;
            }
        }
        System.out.println(reversed);
    }
}
