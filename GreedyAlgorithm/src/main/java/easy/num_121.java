package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class num_121 {
    //121. 买卖股票的最佳时机
    /*
    * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
    * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
    * 设计一个算法来计算你所能获取的最大利润。返回你可以从这笔交易中获取的最大利润。
    * 如果你不能获取任何利润，返回 0 。
    * */

    //超时
    public int maxProfit(int[] prices) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < prices.length; i++) {
            queue.offer(prices[i]);
        }
        int ans = 0 ;
        for (int i = 0; i < prices.length-1; i++) {
            int buyPrice = prices[i] ;
            queue.remove(buyPrice);
            int soldPrice = queue.peek();
            if(soldPrice-buyPrice>ans) {
                ans=soldPrice-buyPrice;
            }
        }
        return ans ;
    }
    //从左到右遍历数组，维护一个最低价格，每访问到一个下标，更新最小价格或最大利润
    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int ans = 0 ;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i]<=minPrice) {
                minPrice = prices[i];
            } else {
                ans = Math.max(ans,prices[i]-minPrice);
            }
        }
        return ans;
    }

}
