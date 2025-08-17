package DP;
import java.util.*;
public class minimum_partition{

    public static int minPartition(int nums[]){
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n;i++){
            sum += nums[i];
        }
        int W = sum/2;
        int [][]dp = new int[n+1][W+1];

        // we will not going to perform any initialization process
        for(int i=1; i< n+1; i++){
            for(int j=1; j < W+1; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = Math.max(nums[i-1]+ dp[i-1][j-nums[i-1]], dp[i-1][j]);

                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1=  dp[n][W];
        int sum2 = sum -sum1;
        return Math.abs(sum1-sum2);
    }
    
    public static void main(String[]args){
        int nums[] = {1,6,11,5};
        System.out.println(minPartition(nums));
    }
}