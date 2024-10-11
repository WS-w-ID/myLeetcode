class Solution {
    public int maxProfit(int[] prices) {
        /**动归
         * 1. (天数,价格,买入,卖出) -> 最大利润
         * 2. 【最大现金金额】：持有股票dp[][0]<0,没有股票dp[][1]>=0, 输出 dp[n-1][1];
                第i天持有股票:
                    dp[i][0] = dp[i-1][0]   ,   第i-1天就持有了
                    dp[i][0] = dp[i-1][1]-prices[i]   ,   第i-1天没有,今天买的
                    最大现金金额: dp[i][0] = max(dp[i-1][0], dp[i-1][1]-prices[i]);
                第i天没有股票:
                    dp[i][1] = dp[i-1][1]   ,   第i-1天就没有,今天也没买
                    dp[i][1] = dp[i-1][0]+prices[i]    ,   第i天有股票，今天卖了
                    最大现金金额: dp[i][1] = max(dp[i-1][1], dp[i-1][0]+prices[i] );
         * 3. 初始条件：dp[0][0]=prices[0]; dp[0][1]=0;
         */
        int n=prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i=1;i<n;++i){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]+prices[i]);
        }
        
        return dp[n-1][1];
    }
}
