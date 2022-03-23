package org.example.blackrock.hackerrank;

import java.util.*;

public class ClimbingLeaderboard {

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        ArrayList<Integer> ranks = new ArrayList<>(), score = new ArrayList<>();
        int count = 1, n = ranked.size();
        ranks.add(1);
        score.add(ranked.get(0));
        for(int i=1; i < n; i++){
            if(ranked.get(i) != ranked.get(i -1)){
                ranks.add(++count);
                score.add(ranked.get(i));
            }
        }

        for(int i=0; i < player.size(); i++){
            System.out.println(rank(ranks, score, player.get(i)));
        }

        return null;
    }

    public static int rank(ArrayList<Integer> ranks , ArrayList<Integer>  score, int x){
        int start=0, end = ranks.size() - 1;
        int mid = 0;
        while(start <= end){
             mid = (start + end) / 2;
            if(x < score.get(mid)){
                end = mid - 1;
            } else if(x > score.get(mid)){
                start = mid + 1;
            }else{
               return ranks.get(mid);
            }
        }
        if(score.get(mid)<x){
            return (mid+1);
        }
        else {
            return (mid+2);
        }
    }

    public static void main(String[] args) {
        List<Integer> ranked = Arrays.asList(100,100,50,40,40,20,10);
        List<Integer> player = Arrays.asList(5,25,50,120);
        climbingLeaderboard(ranked, player);
    }

}

