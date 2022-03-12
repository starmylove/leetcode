package medium;

import org.junit.Test;

import java.util.Arrays;

public class num_322 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if(amount == 0){
            return 0;
        }
        if(coins[0] > amount){
            return -1 ;
        }
        int[] dp = new int[amount+1];
        for (int i = 1; i <= amount ; i++) {
            int min = Integer.MAX_VALUE;
            for(int coin : coins){
                if(coin > i ){
                    break;
                }else{
                    min = Math.min(min,dp[i-coin]);
                }
            }
            if(min == Integer.MAX_VALUE){
                dp[i] = min ;
            }else {
                dp[i] = min + 1 ;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    @Test
    public void test(){
        System.out.println(coinChange(new int[]{1}, 0));
    }
}
