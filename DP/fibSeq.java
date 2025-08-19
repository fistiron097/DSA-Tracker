package DP;

import java.util.Arrays;

public class fibSeq {
    public static int fibSeq(int n, int[]dp){
        if(n ==0 || n== 1){
            return n;
        }
        if(dp[n] != -1){
           return dp[n];
        }
        return dp[n] =  fibSeq(n-1, dp) + fibSeq(n-2, dp);
    }

    public static void main(String[]args){
        int n =3;
        int [] dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibSeq(n, dp));
    }
}


