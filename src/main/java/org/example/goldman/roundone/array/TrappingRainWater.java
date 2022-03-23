package org.example.goldman.roundone.array;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[]   = {3, 0, 2, 0, 4};
        int lArr[] = new int[arr.length];
        int rArr[] = new int[arr.length];
        int n = arr.length, max = 0;


        lArr[0] = arr[0];
        for(int i =1; i < arr.length; i++){
               lArr[i] = Math.max(arr[i], lArr[i - 1]);
        }

        rArr[n-1] = arr[n-1];
        for(int i= n-2; i >= 0; i--){
            rArr[i] = Math.max(arr[i], rArr[i + 1]);
        }

        for(int i = 0; i < arr.length; i++){
            max += Math.min(lArr[i], rArr[i]) - arr[i];
        }

        System.out.println("Max:: " + max);
    }
}
