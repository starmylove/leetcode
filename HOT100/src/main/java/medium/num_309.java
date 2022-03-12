package medium;

public class num_309 {
    public int maxProfit(int[] prices) {
        int m1 = - prices[0]  ; //手里有股票
        int m2 = 0  ;//手里没股票，而且在冰冻期
        int m3 = 0 ;//手里没股票，没在冰冻期
        for (int i = 1; i < prices.length; i++) {
            int t = m2 ;
            m2 = m1 + prices[i];//今天卖的
            m1 = Math.max(m1,m3 - prices[i]);//可能是今天买的，也可能是昨天买的
            m3 = Math.max(t,m3);//之前卖了，今天没买
        }
        return Math.max(m2,m3);
    }
}
