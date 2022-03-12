package easy;

public class num_122 {
    //122. 买卖股票的最佳时机 II
    /*
    * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。
    * 你可以尽可能地完成更多的交易（多次买卖一支股票）。
    * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    * */
    // 22% 97%
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0] ;
        dp[0][1] = 0 ;
        for (int i = 1 ; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
        }
        return dp[prices.length-1][1];
    }
    //时间击败99的代码
    public int maxProfit1(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int cmp = prices[i + 1] - prices[i];
            if (cmp > 0) {
                result += cmp;
            }
        }
        return result;
    }

    // 99%
    //思路
    public int maxProfit2(int[] prices) {
        int res = 0 ;
        for (int i = 0; i < prices.length - 1; i++) {
            res += prices[i+1]>prices[i] ? prices[i+1] - prices[i] : 0 ;
        }
        return res;
    }
}
