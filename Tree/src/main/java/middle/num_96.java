package middle;

import org.junit.Test;

public class num_96 {
    /*
    * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
    * 返回满足题意的二叉搜索树的种数。
    * */
    //已超时
    public int numTrees(int n) {
        return numTrees(1,n);
    }

    private int numTrees(int start, int end) {
        int sum = 0;
        if(start>end) {
            return 1;
        }
        if(start==end) {
            return 1;
        }
        for(int i = start ; i <= end ; i++){
            int leftsum = numTrees(start,i-1);
            int rightsum = numTrees(i+1,end);
            sum += leftsum*rightsum;
        }
        return sum;
    }
    @Test
    public void test(){
        int ans = numTrees(3);
        System.out.println(ans);
    }

}
