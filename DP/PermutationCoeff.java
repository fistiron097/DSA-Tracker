package DP;

public class PermutationCoeff {
    static final int MOD = 1000000007;
    static int[][] dp;

    public static int permutationCoeff(int n, int k) {
        // Base cases
        if (k == 0) return 1;
        if (n == 0) return 0;

        // Check memo
        if (dp[n][k] != -1) return dp[n][k];

        // Recurrence: P(n,k) = n * P(n-1, k-1)
        long ans = ( (long) n * permutationCoeff(n - 1, k - 1) ) % MOD;
        dp[n][k] = (int) ans;
        return dp[n][k];
    }

    public static void main(String[] args) {
        int n = 10, k = 2;
        dp = new int[n + 1][k + 1];

        // initialize dp with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(permutationCoeff(n, k)); // expected 90 (10P2)
    }
}
