package org.example.ds.array;

import java.util.Arrays;

public class MergeSortedArray {

    // Merge arr1[0..n1-1] and arr2[0..n2-1]
    // into arr3[0..n1+n2-1]
    public static void mergeArrays(int[] arr1, int[] arr2, int n1,
                                   int n2, int[] arr3)
    {
        int i = 0, j = 0, k = 0;

        while (i<n1 && j <n2)
        {
            if (arr1[i] < arr2[j])
                arr3[k++] = arr1[i++];
            else
                arr3[k++] = arr2[j++];
        }

        // Store remaining elements of first array
        while (i < n1)
            arr3[k++] = arr1[i++];

        // Store remaining elements of second array
        while (j < n2)
            arr3[k++] = arr2[j++];
    }

    public static void main(String[] args) {
        int []arr1 = {1,6,3,9,5};
        int []arr2 = {2,7,8,4,10};

        //mergeArrays(arr1, arr2, arr1.length, arr2.length, merged);

        int []merged = new int[arr1.length + arr2.length];
        int i=0,j=0,index=0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                merged[index++] = arr1[i];
                i++;
            }else {
                merged[index++] = arr2[j];
                j++;
            }
        }

        System.arraycopy(arr1, i, merged, index, arr1.length - i);
        System.arraycopy(arr2, j, merged, index, arr2.length - j);

        System.out.println(Arrays.toString(merged));

    }
}
