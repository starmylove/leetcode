package middle;

import org.junit.Test;

public class num_97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) {
            return false;
        }
        if(s3.length()==0) {
            return true;
        }
        int l = 0 , r = 0 ;
        int[] dp = new int[s3.length()];
        dfs(s1,s2,s3,l,r,dp,0);
        return dp[dp.length-1]==1;
    }

    private void dfs(String s1, String s2, String s3, int l, int r, int[] dp,int step) {
        if( l == s1.length()  && r == s2.length()  ) {
            return;
        }
        if(l < s1.length() &&r < s2.length() && s2.charAt(r) != s3.charAt(step)&& s1.charAt(l) != s3.charAt(step)) {
            return;
        }
        if(l == s1.length() && ! s2.substring(r,s2.length()).equals(s3.substring(step,s3.length()))) {
            return;
        }
        if(r == s2.length() && ! s1.substring(l,s1.length()).equals(s3.substring(step,s3.length()))) {
            return;
        }
        if(l < s1.length()  && r < s2.length()){
            if(s2.charAt(r)==s3.charAt(step)) {
                dp[step] = 1 ;
                dfs(s1,s2,s3,l,r+1,dp,step+1);
            }
            if(s1.charAt(l)==s3.charAt(step)) {
                dp[step] = 1 ;
                dfs(s1,s2,s3,l+1,r,dp,step+1);
                if(dp[dp.length-1]==1) {
                    return;
                }
            }
        }else {
            dp[dp.length-1]=1;
        }
    }
    public boolean isInterleave1(String s1, String s2, String s3) {
        if((s1.length()+s2.length())!=s3.length()) {
            return false;
        }
        if(s3.length()==0) {
            return true;
        }
        int l1 = s1.length() , l2 = s2.length() ;
        if(l1==0) {
            return s2.equals(s3);
        }
        if(l2==0) {
            return s1.equals(s3);
        }
        int[][] dp = new int[l2+1][l1+1];
        for (int i = 1; i <= l1; i++) {
            if(s1.charAt(i-1)==s3.charAt(i-1)) {
                dp[0][i] = 1 ;
            } else {
                break;
            }
        }
        for (int i = 1; i <= l2; i++) {
            if(s2.charAt(i-1)==s3.charAt(i-1)) {
                dp[i][0] = 1 ;
            } else {
                break;
            }
        }
        for (int i = 1; i <= l2; i++) {
            for (int j = 1; j <= l1 ; j++) {
                if(dp[i-1][j]==0&&dp[i][j-1]==0) {
                    continue;
                }
                if(dp[i-1][j]==1 && s2.charAt(i-1) == s3.charAt(i+j-1)){
                    dp[i][j]=1;
                    continue;
                }
                if(dp[i][j-1]==1 && s1.charAt(j-1) == s3.charAt(i+j-1)){
                    dp[i][j]=1;
                    continue;
                }
            }
        }
        return dp[l2][l1]==1;
    }
    @Test
    public void test(){
        boolean interleave = isInterleave1("aabaac", "aadaaeaaf", "aadaaeaabaafaac");
        System.out.println(interleave);
    }
}
