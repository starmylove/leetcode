package medium;

import java.util.Arrays;

public class num_416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;
        if(n < 2){
            return false;
        }
        int sum = 0 ;
        for(int num : nums){
            sum += num ;
        }
        if((sum & 1) == 1 ){
            return false ;
        }
        sum >>= 1 ;
        Arrays.sort(nums);
        if(nums[n-1] > sum){
            return false;
        }
        boolean[][] dp = new boolean[n][sum + 1] ;
        for(int i = 0 ; i < n ; i ++){
            dp[i][0] = true ;
        }
        dp[0][nums[0]] = true ;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum ; j++) {
                if(dp[i-1][j]){
                    dp[i][j] = true ;
                }else if(j >= nums[i]){
                    dp[i][j] = dp[i-1][j-nums[i]];
                }
            }
        }
        return dp[n-1][sum];
    }
}
