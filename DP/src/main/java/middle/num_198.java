package middle;

import org.junit.Test;

public class num_198 {
    //打家劫舍
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length] ;
        if (nums.length == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1],nums[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2] );
        }
        return dp[nums.length-1];
    }

    //不用数组存储
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int a = nums[0];
        int b = Math.max(nums[1],nums[0]);
        int c = 0 ;
        for (int i = 2; i < nums.length; i++) {
            c = Math.max(b,nums[i]+a );
            a=b;
            b=c;
        }
        return nums.length>2?c:b;
    }
    @Test
    public void test(){
        int rob = rob(new int[]{1, 2, 3, 1});
        System.out.println(rob);
    }
}
