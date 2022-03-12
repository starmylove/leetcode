package hard;

import org.junit.Test;

public class num_639 {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') {
            return 0 ;
        }
        int length = s.length();
        if(length==1) {
            return s.charAt(0)=='*'?9:1;
        }
        long[][] dp = new long[length][2];
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            nums[i] = s.charAt(i) - '0' ;
        }
        dp[0][0] = nums[0] == -6 ? 9 : 1 ;
        dp[0][1] = 0 ;
        dp[1][0] = nums[1]== -6 ? 9 * dp[0][0] : nums[1] == 0 ? 0 : dp[0][0] ;
        if(nums[0]==('*'-'0')){
            if(nums[1]==('*'-'0')){
                dp[1][1] = 15 ;
            }else if(nums[1] < 7){
                dp[1][1] = 2 ;
            }else {
                dp[1][1] = 1 ;
            }
        }else if(nums[0]==1){
            dp[1][1] = nums[1]==-6?9 : 1 ;
        }else if(nums[0]==2){
            dp[1][1] = nums[1]==-6?6 : (nums[1]<7?1:0);
        }
        for (int i = 2 ; i < length ; i ++ ) {
            //独立
            if(nums[i]==('*'-'0')){
                dp[i][0] = (9 * ( dp[i-1][0]+dp[i-1][1])) % 1000000007 ;
            }else if(nums[i]!=0){
                dp[i][0] =  (dp[i-1][0]+dp[i-1][1])%1000000007 ;
            }
            //不独立
            if(nums[i-1]==('*'-'0')){
                if(nums[i]==('*'-'0')){
                    dp[i][1] = (15 * dp[i-1][0] / 9 )%1000000007 ;
                }else if( -1< nums[i] &&nums[i] < 7 ){
                    dp[i][1] = (dp[i-1][0] * 2 / 9 )%1000000007;
                }else if( 6< nums[i] &&nums[i] < 10 ){
                    dp[i][1] = (dp[i-1][0] / 9)%1000000007;
                }
            }else if(nums[i-1] == 1){
                dp[i][1] = (nums[i] == -6 ? 9*dp[i-1][0] : dp[i-1][0] )%1000000007;
            }else if(nums[i-1] == 2){
                dp[i][1] = (nums[i] == -6 ? 6*dp[i-1][0] : (nums[i] < 7 ? dp[i-1][0] : 0))%1000000007 ;
            }
        }
        return (int)((dp[length-1][0] + dp[length-1][1])%1000000007 );
    }
    @Test
    public void test(){
        int i = numDecodings("1*6*7*1*9*6*2*9*2*3*3*6*3*6*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*4*");
        System.out.println(i);
    }
}
