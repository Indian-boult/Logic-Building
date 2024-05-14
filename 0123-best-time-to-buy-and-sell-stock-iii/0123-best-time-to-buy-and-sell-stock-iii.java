class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp1 = new int[n][2];
        int[][] dp2 = new int[n][2];
        dp1[0][0] = prices[0];
        dp1[0][1] = -prices[0];
        
        for(int i=1;i<n;i++){
            dp1[i][0] = Math.min(prices[i], dp1[i-1][0]);
            dp1[i][1] = Math.max(dp1[i-1][1], prices[i] - dp1[i-1][0]);
        }
        dp2[0][0] = prices[0];
        dp2[0][1] = -prices[0];
        for(int i=1;i<n;i++){
            dp2[i][0] = dp1[i-1][1] - prices[i];
        }
        int maxs = 0;
        for(int i= n-1;i>0; i--) {
            maxs = Math.max(maxs, prices[i]);
            dp2[i][1] =  maxs + dp2[i][0];
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            ans = Math.max(dp1[i][1], ans);
            ans = Math.max(dp2[i][1], ans);
        }
        return ans;
    }
}