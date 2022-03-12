package hard;

public class num_32_2 {
    //32. 最长有效括号
    /*
     *给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * */
    public int longestValidParentheses(String s) {
        int left = 0 , right = 0 , maxLength = 0 ;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') {
                left++;
            } else {
                right++;
            }
            if(left==right) {
                maxLength = Math.max(maxLength,2*left);
            } else if(left<right) {
                left = right = 0 ;
            }
        }
        left = right = 0 ;
        for (int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i)=='(') {
                left++;
            } else {
                right++;
            }
            if(left==right) {
                maxLength = Math.max(maxLength,2*left);
            } else if(left>right) {
                left = right = 0 ;
            }
        }
        return maxLength;
    }
}
