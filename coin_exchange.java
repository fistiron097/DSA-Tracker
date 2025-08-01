public class coin_exchange{
    public static int coinExchange(int [] coins, int sum){
        int n = coins.length;
        int [][]dp = new int[n+1][sum+1];

        for(int i=0; i < n+1; i++){
            dp[i][0] = 1;
        }

        for(int i=1; i<n+1;i++){
            for(int j=1; j < sum+1; j++){
                int val = coins[i-1];
                if(val <= j){
                    dp[i][j] = dp[i][j-val] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        print(dp);
        return dp[n][sum];
        

    }
    public static void print(int [][]dp){
        for(int i=0; i< dp.length; i++){
            for(int j=0; j < dp[0].length;j++){
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[]args){
        int [] coins = {2,5,3,6};
        int sum = 10;
        System.out.println(coinExchange(coins, sum));
    }
}