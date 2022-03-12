package easy;

import org.junit.Test;

public class num_171 {
    public int titleToNumber(String columnTitle) {
        int ans = 0 ;
        int factor = 1;
        for (int i = columnTitle.length()-1; i >= 0 ; i--) {
            ans+=(int)(columnTitle.charAt(i)-64)*factor;
            factor *= 26;
        }
        return ans;
    }
    @Test
    public void test(){
        int ab = titleToNumber("AB");
        System.out.println(ab);
    }
}
