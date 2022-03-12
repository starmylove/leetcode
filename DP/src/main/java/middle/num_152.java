package middle;

import org.junit.Test;

import java.util.Arrays;

public class num_152 {
    public int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(nums[i],Math.max(nums[i]*dp[i-1][0], nums[i]*dp[i-1][1]));
            dp[i][1] = Math.min(nums[i],Math.min(nums[i]*dp[i-1][0], nums[i]*dp[i-1][1]));
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if(max < dp[i][0]) {
                max = dp[i][0];
            }
        }
        return max ;
    }
    @Test
    public void test(){
        int[] nums = new int[]{-100,1,1,-100,-100,-100};
        int i = maxProduct(nums);
        System.out.println(i);
    }
}
