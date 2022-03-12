package middle;

import java.util.Arrays;

public class Offer_49 {
    //剑指 Offer 49. 丑数
    /*
    * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    * */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1 ;
        int p2 = 1 , p3 = 1 ,p5 = 1 ;
        for (int i = 2; i <= n; i++) {
            int a = 2 * dp[p2];
            int b = 3 * dp[p3];
            int c = 5 * dp[p5];
            int min = a > b ? b : a;
            min = c > min ? min : c;
            dp[i] = min ;
            if(a == min){
                p2++;
            }
            if(b == min){
                p3++;
            }
            if(c == min){
                p5++;
            }
        }
        return dp[n];
    }
}
