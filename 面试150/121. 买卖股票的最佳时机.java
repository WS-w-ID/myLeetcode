class Solution {
    public int maxProfit(int[] prices) {
        /**动归
         * 1. (天数,价格) -> 最大利润
         * 2. 第i天的最大利润 = max(第i-1天的最大利润, 当天价格-目前最低价格)
         * 3. 第1天的最大利润为 0
         */
        int n=prices.length, ans=0, minPrice = prices[0];
        for(int i=1;i<n;++i){
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }
        
        return ans;
    }
}
