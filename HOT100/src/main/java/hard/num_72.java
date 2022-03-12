package hard;

import org.junit.Test;

public class num_72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length() , len2 = word2.length() ;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i ;
        }
        for (int i = 0; i <= len2; i++) {
            dp[0][i] = i ;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int a = dp[i-1][j] , b = dp[i][j-1] ;
                int c = dp[i-1][j-1];
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    c -- ;
                }
                dp[i][j] = 1 + Math.min(a,Math.min(b,c));
            }
        }
        return dp[len1][len2];
    }
    @Test
    public void test(){
        minDistance("","a");
    }
}
