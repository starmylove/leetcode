package hard;

import org.junit.Test;

import java.util.Arrays;

public class num_44 {
    //像屎一样，虽然快
    public boolean isMatch(String s, String p) {
        if("".equals(s)&& "".equals(p)) {
            return true ;
        }
        if(!"".equals(s)&& "".equals(p)) {
            return false ;
        }
        if("".equals(s)&&!"".equals(p)&&!only(p)) {
            return false ;
        }
        int row = p.length() , col = s.length() ;
        boolean[][] dp = new boolean[row][1+col];
        char[] pchars = p.toCharArray();
        char[] schars = s.toCharArray();
        int start = 1 ;
        if(pchars[0]=='*'){
            Arrays.fill(dp[0],true);
        }
        else if(pchars[0]=='?'){
            Arrays.fill(dp[0],false);
            dp[0][1] = true ;
            start++;
        }else {
            if(pchars[0]!=schars[0]) {
                return false;
            }
            Arrays.fill(dp[0],false);
            dp[0][1] = (pchars[0] == schars[0]) ;
            start++;
        }
        for (int i = 1; i < row; i++) {
            if(pchars[i]=='*'){
                int m = 0 ;
                for (m = 0; m < col + 1; m++) {
                    if(dp[i-1][m]==true) {
                        break;
                    }
                }
                for (int j = m; j <= col; j++) {
                    dp[i][j] = true ;
                }
                continue;
            }else if(pchars[i]=='?'){
                for (int j = start; j <= col; j++) {
                    if(dp[i-1][j-1]) {
                        dp[i][j]=true;
                    }
                }
                start++;
            }else {
                for (int j = start; j <= col; j++) {
                    if(dp[i-1][j-1]&&pchars[i]==schars[j-1]) {
                        dp[i][j] = true ;
                    }
                }
                start++;
            }

        }
        return dp[row-1][col];
    }

    private boolean only(String p) {
        for (int i = 0; i < p.length(); i++) {
            if(p.charAt(i)!='*') {
                return false;
            }
        }
        return true;
    }
    //官方题解 弟弟，太慢了
    public boolean isMatch1(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n ; i++) {
            if(p.charAt(i)=='*') {
                dp[0][i] = true ;
            } else {
                break;
            }
        }
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n; j++) {
                if(p.charAt(j-1)=='*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1] ;
                } else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
    @Test
    public void test(){
//        System.out.println(""==null);
        boolean adceb = isMatch("acdcb", "a*c?b");
        System.out.println(adceb);
    }
}
