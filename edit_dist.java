import java.util.*;
public class edit_dist {
    public static int editDist(String word1, String word2){
        int n = word1.length();
        int m = word2.length();

        int [][]dp = new int[n+1][m+1];

        for(int i=0; i<n+1; i++){
            for(int j=0; j < m+1; j++){
                if(i ==0){
                    dp[i][j] = j;
                }
                if(j ==0){
                    dp[i][j] = i;
                }
            }
        }
        for(int i=1; i < n+1; i++){
            for(int j=1; j < m+1; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int add = dp[i][j-1] +1 ;
                    int del = dp[i-1][j] +1 ;
                    int rep = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(add, Math.min(del,rep));
                }
            }
        }
        print(dp);
        return dp[n][m];
    }
    public static void print(int [][]dp){
        for(int i=0; i < dp.length;i++){
            for(int j=0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main(String[]args){
        String word1 = "abc";
        String word2 = "sbd";
        System.out.print(editDist(word1, word2));
    }
}
