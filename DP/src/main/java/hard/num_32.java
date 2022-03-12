package hard;

import org.junit.Test;

public class num_32 {
    //32. 最长有效括号
    /*
    *给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
    * */
    //这次不看答案，自己实现
    public int longestValidParentheses1(String s) {
        int length = s.length();
        if(length<2) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[length];
        if(s.charAt(1)==')'&&s.charAt(0)=='('){
            dp[1] = 2;
            max = 2 ;
        }
        for (int i = 2; i < length; i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = 2 + dp[i-2];
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i] = dp[i-1] + 2 + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0);
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
    //官方题解-照着敲
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length<2) {
            return 0;
        }
        int[] dp = new int[length];
        int max = 0;
        if(s.charAt(1)==')'&&s.charAt(0)=='('){
            dp[1] = 2;
            max = 2 ;
        }
        for (int i = 2; i < length; i++) {
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i] = 2 + dp[i-2];
                }else if(i-dp[i-1]>0 && s.charAt(i-dp[i-1]-1)=='(') {
                    dp[i] = dp[i-1] + (i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
                }
                max = Math.max(max,dp[i]);
            }
        }
        return max;
    }
    //官方题解
    public int longestValidParentheses2(String s) {
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
    @Test
    public void test(){
        String s = "(()())";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
