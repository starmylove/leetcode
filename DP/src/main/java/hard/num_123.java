package hard;

import org.junit.Test;

public class num_123 {
    //123. 买卖股票的最佳时机 III
    /*
    * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
    * 设计一个算法来计算你所能获取的最大利润。
    * 你最多可以完成 两笔 交易。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    * */
    // 77% 84%
    public int maxProfit(int[] prices) {
        int buy1 = - prices[0] , sell1 = 0 ;
        int buy2 = - prices[0] , sell2 = 0 ;
        for (int i = 1; i < prices.length; i++) {
            sell1 = Math.max(sell1,prices[i]+buy1);
            buy1 = Math.max(buy1,-prices[i]);
            sell2 = Math.max(sell2,prices[i]+buy2);
            buy2 = Math.max(buy2,sell1-prices[i]);
        }
        return sell2;
    }
    public int maxProfit1(int[] prices) {
        int buy1 = -prices[0] , sell1 = 0 ;
        int buy2 = -prices[0] , sell2 = 0 ;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            sell1 = Math.max(sell1,prices[i]+buy1);
            buy1 = Math.max(buy1,-prices[i]);
            sell2 = Math.max(sell2,prices[i]+buy2);
            buy2 = Math.max(buy2,sell2-prices[i]);
        }
        return sell2;
    }

    @Test
    public void test(){
        int[] prices = new int[]{1,2,3,4,5};
        int i = maxProfit(prices);
        System.out.println(i);
    }
}
