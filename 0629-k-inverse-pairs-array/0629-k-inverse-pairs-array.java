class Solution {
    public int kInversePairs(int n, int k) {
        int MOD = (int) Math.pow(10, 9) + 7;
        int[] dp = new int[k + 1];
        dp[0] = 1;

        for (int N = 1; N <= n; N++) {
            int[] temp = new int[k + 1];
            int total = 0;

            for (int K = 0; K <= k; K++) {
                total = (total + dp[K]) % MOD;

                if (K >= N) total = (total - dp[K - N] + MOD) % MOD;
                
                temp[K] = total;
            }

            dp = temp;
        }

        return dp[k];
    }
}