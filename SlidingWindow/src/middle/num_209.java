package middle;

import org.junit.Test;

public class num_209 {
    //209. 长度最小的子数组
    /*
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，
     * 并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, n = nums.length;
        int sum = nums[0] , ans = Integer.MAX_VALUE;
        while (r != n - 1 || sum >= target) {
            if (sum < target) {
                r++ ;
                sum += nums[r] ;
            }else {
                ans = Math.min(ans , r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans  ;
    }
    @Test
    public void test(){
        minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
















