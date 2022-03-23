package org.example.goldman.roundone.array.top50;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
        int N = 4, K = 6;
        int arr[] = {1, 5, 7, 1};
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] + arr[j] == K) {
                    System.out.println(arr[i] + " - " + arr[j]);
                }
            }
        }
    }
}
