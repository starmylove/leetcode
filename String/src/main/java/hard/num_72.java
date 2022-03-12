package hard;

import org.junit.Test;

public class num_72 {
    /*
    * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
你可以对一个单词进行如下三种操作：
    插入一个字符
    删除一个字符
    替换一个字符
    * */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i ;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i ;
        }
        for (int i = 1; i <= word1.length() ; i++) {
            for (int j = 1; j <= word2.length() ; j++) {
                int a = dp[i-1][j] + 1 ;
                int b = dp[i][j-1] + 1 , c ;
                if(word1.charAt(i - 1)==word2.charAt(j - 1)){
                    c = dp[i - 1][j - 1] ;
                }else {
                    c = dp[i - 1][j - 1] + 1 ;
                }
                dp[i][j] = Math.min(a,Math.min(b,c));
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public int minDistance1(String word1, String word2) {
        int length1 = word1.length() , length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i ;
        }
        for (int i = 0; i <=  length2; i++) {
            dp[0][i] = i ;
        }
        for (int i = 1; i <= length1  ; i++) {
            for (int j = 1; j <= length2  ; j++) {
                int a = dp[i-1][j]+1;
                int b = dp[i][j-1]+1;
                int c;
                if(word1.charAt(i - 1)==word2.charAt(j - 1 )) {
                    c = dp[i-1][j-1];
                } else {
                    c = dp[i-1][j-1]+1;
                }
                dp[i][j] = Math.min(a,Math.min(c,b));
            }
        }
        return dp[length1][length2];
    }

    @Test
    public void test(){
        int i = minDistance1("horse", "ros");
        System.out.println(i);
    }
}
