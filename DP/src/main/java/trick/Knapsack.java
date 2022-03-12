package trick;

import org.junit.Test;

public class Knapsack {
    //  0/1背包问题
    /*
    * 01背包是在M件物品取出若干件放在空间为W的背包里，每件物品的体积为W1，W2至Wn，
    * 与之相对应的价值为P1,P2至Pn。01背包是背包问题中最简单的问题。
    * 01背包的约束条件是给定几种物品，每种物品有且只有一个，并且有权值和体积两个属性。
    * 在01背包问题中，因为每种物品只有一个，对于每个物品只需要考虑选与不选两种情况。
    * 如果不选择将其放入背包中，则不需要处理。如果选择将其放入背包中，
    * 由于不清楚之前放入的物品占据了多大的空间，需要枚举将这个物品放入背包后可能占据背包空间的所有情况
    * */
    static int n;           // 描述物品个数
    static int c;           // 描述背包容量
    static int[] value;     // 描述物品价值
    static int[] weight;    // 描述物品重量
    @Test
    public void test(){
        value = new int[]{1500, 3000, 2000, 2000};
        weight = new int[]{1 , 4 , 3 , 1};
        c = 4;
        n = 4;
        pack1(n,c,value,weight);
    }
    // dp[n][c+1]  解法
    public int pack1(int n , int c , int[] value , int[] weight) {
        int[][] dp = new int[n][c+1];
        for (int i = 0; i <= c; i++) {
            dp[0][i] = weight[i]>i?0:value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= c; j++) {
                int x = dp[i-1][j]; //不选该物品
                int y = j >= weight[j] ? value[i] + dp[i-1][j - weight[j]] : 0 ;
                dp[i][j] = Math.max(x,y);
            }
        }
        return dp[n-1][c];
    }


    //dp[2][C+1] 解法
    /*
    * 根据「转移方程」，我们知道计算第 行格子只需要第行中的某些值。也就是计算「某一行」的时候只需要依赖「前一行」。
        因此可以用一个只有两行的数组来存储中间结果，根据当前计算的行号是偶数还是奇数来交替使用第 0 行和第 1 行。
        这样的空间优化方法称为「滚动数组」
    * */
    public int pack2(int n , int c , int[] value , int[] weight) {
        int[][] dp = new int[2][c+1];
        for (int i = 0; i <= c; i++) {
            dp[0][i] = weight[i]>i?0:value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= c; j++) {
                int x = dp[(i-1)&1][j]; //不选该物品
                int y = j >= weight[j] ? value[i&1] + dp[(i-1)&1][j - weight[j]] : 0 ;
                dp[i&1][j] = Math.max(x,y);
            }
        }
        return dp[(n-1)&1][c];
    }



    //dp[C+1] 解法
    public int pack3(int n , int c , int[] value , int[] weight) {
        int[] dp = new int[c+1];
        for (int i = 0; i <= c; i++) {
            dp[i] = weight[i]>i?0:value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= weight[i]; j--) {
                int x = dp[j]; //不选该物品
                int y = value[i&1] + dp[j - weight[j]] ;
                dp[j] = Math.max(x,y);
            }
        }
        return dp[c];
    }
}
