package middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class num_313 {
    //313. 超级丑数
    /*
    * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
    * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
    * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
    * */

    //方法1  堆
    // 19% 5%
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n==1) {
            return 1;
        }
        PriorityQueue<Long> heap = new PriorityQueue();
        Set<Long> set = new HashSet<>();
        set.add(1L);
        heap.offer(1L);
        for (int i = 0; i < n; i++) {
            long poll = heap.poll();
            if(i==n-1) {
                return (int)poll;
            }
            for (int j = 0; j < primes.length; j++) {
                if(!set.contains(poll*primes[j])){
                    set.add(poll*primes[j]);
                    heap.offer(poll*primes[j]);
                }
            }
        }
        return 0;
    }

    //动态规划
    // 63% 86%
    public int nthSuperUglyNumber1(int n, int[] primes) {
        int[] dp = new int[n+1];
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers,1);
        dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < pointers.length; j++) {
                min = Math.min(primes[j] * dp[pointers[j]] , min);
            }
            dp[i] = min ;
            for (int j = 0; j < pointers.length; j++) {
                if(min == primes[j] * dp[pointers[j]]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }


    @Test
    public void test(){
        int i = nthSuperUglyNumber(100000, new int[]{7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251});
        System.out.println(i);
    }
}













