package middle;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class num_264 {
    //264. 丑数 II
    /*
    * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
    * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
    * */
    // 25% 23%
    public int nthUglyNumber(int n) {
        if(n==1) {
            return 1;
        }
        int[] primes = new int[]{2,3,5};
        PriorityQueue<Long> heap = new PriorityQueue();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        heap.offer(1L);
        for (int i = 0; i < n; i++) {
            long poll = heap.poll();
            if(i==n-1) {
                return (int)poll;
            }
            for (int j = 0; j < 3; j++) {
                if(!set.contains(poll*primes[j])){
                    set.add(poll*primes[j]);
                    heap.offer(poll*primes[j]);
                }
            }
        }
        return 0;
    }

    //动态规划
    // 99% 71%
    public int nthUglyNumber1(int n ) {
        int[] dp = new int[n+1];
        dp[1] = 1 ;
        int p2 = 1 , p3 = 1 , p5 = 1 ;
        for (int i = 2; i < n + 1 ; i++) {
            dp[i] =  Math.min(2 * dp[p2],Math.min(3 * dp[p3],5 * dp[p5]));
            if(dp[i] == 2 * dp[p2]) {
                p2++;
            }
            if(dp[i] == 3 * dp[p3]) {
                p3++;
            }
            if(dp[i] == 5 * dp[p5]) {
                p5++;
            }
        }
        return dp[n];
    }

}
