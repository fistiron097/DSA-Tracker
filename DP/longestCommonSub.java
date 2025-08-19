package DP;
public class longestCommonSub{
    public static int lcsTab(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int ans = 0;

        int [][] dp = new int[n+1][m+1];
        for(int i=0; i<n+1; i++){
            for(int j=0; j < m+1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
            }
        }
        for(int i=1; i < n+1; i++){
            for(int j=1; j < m+1; j++){
                if(str1.charAt(i-1) == str2.charAt(m-1) && i != j){
                    dp[i][j] = dp[i-1][j-1] +1;
                    ans = Math.max(ans,dp[i][j]);
                }else{
                    // we put here 0 because our logic says whenever characters matches fine as soon as it stopped we make our count value to 0
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    public static void main(String[]args){
        String str1 = "axxy";
        String str2 = "axxy";
        System.out.println(lcsTab(str1, str2));
        
    }
}