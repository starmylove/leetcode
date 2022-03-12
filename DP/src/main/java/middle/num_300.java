package middle;

import org.junit.Test;

public class num_300 {

    /*
    * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
    * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    * */

    //DP解法
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[]dp = new int[length];
        dp[0] = 1 ;
        int ans = 1 ;
        for (int i = 1 ; i < length ; i++) {
            int num = nums[i];
            int max = 0 ;
            for (int j = 0 ; j < i ; j++) {
                if (max<dp[j]&&nums[j]<=num){
                    max = dp[j];
                }
            }
            dp[i] = max+1;
            if(dp[i]>ans) {
                ans=dp[i];
            }
        }
        return ans;
    }
    @Test
    public void test(){
        int length = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }
}
