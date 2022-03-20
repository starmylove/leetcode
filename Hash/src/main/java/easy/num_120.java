package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class num_120 {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if(a.length() < b.length()){
                return -1;
            }else if(a.length() > b.length()){
                return 1;
            }
            return b.compareTo(a);
        });
        if(words.length == 0 || words[0].length() > 1){
            return "";
        }
        String ans = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for(int i = 0; i < words.length; i ++){
            if(set.contains(words[i].substring(0,words[i].length() - 1))){
                set.add(words[i]);
                ans = words[i];
            }
        }
        return ans;
    }

    public int min(int n, int[] a, int[] b){
        int[][] dp = new int[n][3];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            if(a[i] == 1){
                dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]);
            }
            if(b[i] == 1){
                dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]);
            }
            dp[i][0] = Math.min(Math.min(dp[i-1][0],dp[i-1][1]),dp[i-1][2]) + 1;
        }
        return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }

    @Test
    public void test(){
        String s = longestWord(new String[]{"a","banana","app","appl","ap","apply","apple"});
        System.out.println(s);
    }
}