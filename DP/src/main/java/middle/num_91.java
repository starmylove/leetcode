package middle;

import org.junit.Test;

public class num_91 {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0 ;
        }
        int length = s.length();
        if(length==1) {
            return 1;
        }
        int[][] dp = new int[length][2];
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = s.charAt(i) - '0' ;
        }
        dp[0][0] = 1 ;
        dp[0][1] = 1 ;
        dp[1][0] = nums[1]==0? 0 : 1  ;
        dp[1][1] = merge(nums[0],nums[1]);
        for (int i = 2; i < length; i++) {
            if(nums[i] != 0) {
                dp[i][0] = dp[i-1][0] + dp[i-1][1] ;
            }
            if(merge(nums[i-1],nums[i])==1) {
                dp[i][1] = dp[i-1][0] ;
            }
//            else
//                dp[i][1] = 1 ;
        }
        return dp[length-1][0] + dp[length-1][1] ;
    }
    int merge(int a , int b ){
        if(a > 2 || a == 0) {
            return 0;
        }
        if(a == 2 && 6 < b ) {
            return 0 ;
        }
        return 1;
    }
    @Test
    public void test(){
        int i = numDecodings("60001");
        System.out.println(i);
    }
}
