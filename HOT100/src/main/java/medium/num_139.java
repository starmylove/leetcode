package medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String > set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i <= s.length() ; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true ;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String > set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        int maxLen = 0 ;
        for(String ss : wordDict){
            maxLen = Math.max(maxLen,ss.length());
        }
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = Math.max(0,i - maxLen + 1); j <= i; j++) {
                if(dp[j] && set.contains(s.substring(j,i+1))){
                    dp[i + 1] = true ;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
