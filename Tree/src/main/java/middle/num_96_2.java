package middle;

import org.junit.Test;

public class num_96_2 {
    /*
     * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
     * 返回满足题意的二叉搜索树的种数。
     * */
    //试试动态规划，因为相同长度的子区间，所能形成的树的种类个数是固定的，前面超时的方法中，进行了重复计算
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1 ;
        dp[1] = 1 ;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
    @Test
    public void test(){
        int ans = numTrees(3);
        System.out.println(ans);
    }
}
