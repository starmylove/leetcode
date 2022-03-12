package middle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class num_139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true ;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true ;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    public boolean wordBreak1(String s, List<String> wordDict) {
        int maxw = 0 , minw = 90000000;
        Set<String> wordDictSet = new HashSet<>();
        for (int i = 0; i < wordDict.size(); i++) {
            maxw = Math.max(maxw,wordDict.get(i).length());
            minw = Math.min(minw,wordDict.get(i).length());
            wordDictSet.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true ;
        for (int i = minw; i < s.length()+1; i++) {
            for (int j = (i-maxw>0)?i-maxw:0; j <= i - minw; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i] = true ;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
