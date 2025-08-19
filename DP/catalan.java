package DP;
// Concept of this comes in question:- 1.Count Trees, 2- Mountains Ranges
public class catalan {
    public static int catalanTab(int n){
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i <= n; i++){
            for(int j=0; j < i; j++){
                dp[i] += dp[j] *dp[i-j-1];
            }
        }
        return dp[n];
    }
    public static void main(String[]args){
        int n =2;
        System.out.println(catalanTab(n));
    }
}
