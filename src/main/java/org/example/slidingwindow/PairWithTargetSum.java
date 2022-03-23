package org.example.slidingwindow;

public class PairWithTargetSum {

    public static void pairWithTargetSum(int []arr, int target){
        int end = arr.length -1;
        for (int start=0; start< arr.length; start++){
            int temp1 = arr[start];
            int temp2 = arr[end];
            if(temp1 + temp2 == target){
                System.out.println("Start:: " + start + " end:: " + end);
                break;
            }
            if(temp1 + temp2 > target){
                end--;
            }else{
                start++;
            }
        }
    }

    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 6};
        int target = 6;
        pairWithTargetSum(arr, target);
    }
}
