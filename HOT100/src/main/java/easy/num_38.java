package easy;

public class num_38 {
    public int[] countBits1(int n) {
        if(n == 0){
            return new int[]{0};
        }
        int[] dp = new int[n + 1];
        dp[1] = 1 ;
        int len = 2 ;
        int index = 2 ;
        while (index <= n){
            for (int i = 0; i < len; i++) {
                dp[index] = 1 + dp[index + i - len] ;
                if(++ index == n + 1){
                    return dp;
                }
            }
            len *= 2;
        }
        return dp;
    }
    public int[] countBits(int n) {
        int[] dp = new int[n + 1] ;
        int highBit = 0 ;
        for (int i = 1; i <= n; i++) {
            if((i & (i - 1)) == 0){
                highBit = i ;
            }
            dp[i] = 1 + dp[i - highBit];
        }
        return dp;
    }
}
