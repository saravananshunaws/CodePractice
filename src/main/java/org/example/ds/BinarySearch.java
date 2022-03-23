package org.example.ds;

public class BinarySearch {

    int binarySearch(int arr[]) {
        int find = 5;
        int low = 0;
        int high = arr.length;

        int mid = (low + high) / 2;
        while(low < high){
            if(arr[mid] == find){
                return arr[mid];
            }

            if(find < arr[mid]){
                high = mid;
                low++;
            }

            if(find > arr[mid]){
                low = mid;
                low++;
            }
        }

        return -1;
    }

    // Driver method to test above
    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2, 3, 4, 5, 6};
        int n = arr.length;
        int x = 90;
        int result = ob.binarySearch(arr);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index " + result);
    }
}