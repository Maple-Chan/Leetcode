package leetcode_121_maxProfit;
/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        // int dp[] = new int[prices.length];

        /**
         * 暴力
         */
        // int saleMax = 0;
        // for (int i = 0; i < prices.length; i++) {
        //     for (int j = i + 1; j < prices.length; ++j) {
        //         if (saleMax < (prices[j] - prices[i])) {
        //             saleMax = (prices[j] - prices[i]);
        //         }
        //     }
        // }

        /**
         * 单调栈
         */

        

        /**
         * DP
         */
        int maxProfit = -1;
        int dp[][] = new int[prices.length][2];

        dp[0][1] = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            // 如果今天要卖的话，取昨天卖了和昨天没卖的最大值作为今天卖出的利润
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);

            // 如果今天不卖的话，
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }

        maxProfit = dp[prices.length-1][0];
    

        /**
         * 打擂台
         *  我们发现：其实只需要关心之前（不包括现在）看到的最低股价，
         *  于是在遍历的过程中，记录下之前看到的最低股价，就可以省去内层循环。
         */
        // int minPrice = prices[0];
        // int maxProfit = -1;
        // for (int i = 1; i < prices.length; i++) {
        //     minPrice = Math.min(minPrice, prices[i]);
        //     maxProfit = Math.max(prices[i] - minPrice, maxProfit);
        // }

        return maxProfit;
    }
}
// @lc code=end
