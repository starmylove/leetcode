package middle;

import org.junit.Test;

public class num_55 {
    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     */
    //贪心算法
    public boolean canJump1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>max) {
                return false;
            }
            if(i+nums[i]>=nums.length-1) {
                return true;
            }
            max=Math.max(i+nums[i],max);
        }
        return true;
    }


    //动态规划
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1 ;
        int right = 0 ;
        int index ;
        for ( index = 0; index < nums.length; index++) {
            if(dp[index]!=1) {
                break;
            }
            int max = Math.min(index + nums[index] ,nums.length-1);
            for (int i = right; i <= max ; i++) {
                dp[i] = 1 ;
            }
            right = right<=max?max+1:right;
        }
        return dp[nums.length-1]==1?true:false;
    }
    @Test
    public void test(){
        int[] nums = new int[]{3,2,1,0,4};
        boolean b = canJump(nums);
        System.out.println(b);
    }
}
