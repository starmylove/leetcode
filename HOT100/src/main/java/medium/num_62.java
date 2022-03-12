package medium;

import java.util.Arrays;

public class num_62 {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

        public int uniquePaths1(int m, int n) {
            long ans = 1;
            for (int x = n, y = 1; y < m; ++x, ++y) {
                ans = ans * x / y;
            }
            return (int) ans;
        }
}