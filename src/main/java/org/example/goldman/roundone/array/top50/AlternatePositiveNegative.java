package org.example.goldman.roundone.array.top50;

import java.util.Arrays;

public class AlternatePositiveNegative {

    public static int partition(int[] A){
        int j = 0, pivot = 0;
        for(int i=0; i < A.length; i++){
            if(A[i] < pivot) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                j++;
            }
        }
        return j;
    }

    public static void reArrange(int[] arr){
        int n = arr.length;
        int pos = partition(arr);
        int neg = 0;

        while (pos < n && neg < pos && arr[neg] < 0)
        {
            int temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg += 2;
        }

        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
        int arr[] = { 9, -3, 5, -2, -8, -6, 1, 3};
        reArrange(arr);
        System.out.println(Arrays.toString(arr));
    }
}
