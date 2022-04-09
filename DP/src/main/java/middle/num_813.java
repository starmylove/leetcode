package middle;

import org.junit.Test;

public class num_813 {
    public double largestSumOfAverages(int[] nums, int k) {
        int length = nums.length;
        double[] preSum = new double[length + 1];
        double[][] dp = new double[length + 1][k + 1];
        for (int i = 1; i <= length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            dp[i][1] = preSum[i] / i;
        }
        for (int i = 1; i <= length; i++) {
            for (int j = 2; j <= Math.min(k, i); j++) {
                for (int l = j - 1; l < i; l++) {
                    double num = (preSum[i] - preSum[l]) / (i - l);
                    dp[i][j] = Math.max(dp[i][j], num + dp[l][j - 1]);
                }
            }
        }
        return dp[length][k];
    }
    @Test
    public void test(){
        largestSumOfAverages(new int[]{1,2,3,4,5,6,7}, 4);
    }
}
