package easy;

public class num_121 {
    public int maxProfit(int[] prices) {
        int minprice  = Integer.MAX_VALUE;
        int maxprofit  = 0 ;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < minprice){
                minprice = prices[i] ;
            }else{
                maxprofit  = Math.max(maxprofit ,prices[i] - minprice );
            }
        }
        return maxprofit  ;
    }
}
