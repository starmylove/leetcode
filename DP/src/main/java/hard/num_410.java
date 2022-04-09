package hard;

import java.util.Arrays;

public class num_410 {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int [n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] preSum = new int[n + 1];
        preSum[1] = nums[0];
        for(int i = 2; i <= n; i ++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(m, i); j++) {
                for (int k = j - 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], preSum[i] - preSum[k]));
                }
            }
        }
        return dp[n][m];
    }
    public int splitArray1(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right){
            int mid = ((right - left) >> 1) + left;
            if(check(nums, mid, m)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int[] nums, int x, int m){
        int sum = 0, cnt = 1;
        for(int num : nums) {
            sum += num;
            if(sum > x){
                cnt ++;
                sum = num;
            }
        }
        return cnt <= m;
    }
}
