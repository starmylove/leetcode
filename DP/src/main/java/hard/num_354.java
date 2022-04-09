package hard;

import java.util.Arrays;
import java.util.Comparator;

public class num_354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b) -> a[0] - b[0]);
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        int ans = 1;
        for (int i = 1; i < envelopes.length; i++) {
            for(int j = 0; j < i; j ++){
                if(envelopes[j][0] != envelopes[i][0]){
                    if(envelopes[i][1] > envelopes[j][1]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                        ans = Math.max(ans, dp[i]);
                    }
                }
            }
        }
        return ans;
    }
}
