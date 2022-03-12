package easy;

import org.junit.Test;

public class num_441 {
    public int arrangeCoins(int n) {
        double x = Math.sqrt(2.0 * n + 0.25) - 0.5 ;
        int ans = (int) x ;
        return ans;
    }
    public int arrangeCoins1(int n) {
        int left = 1 , right = n ;
        while (left < right){
            int mid = left+(1-left + right) / 2;
            long mul = ((long) mid * (mid + 1 )) / 2 ;
            if(mul <= (long) n){
                left = mid ;
            }else {
                right = mid -1;
            }
        }
        return left;
    }
    public int arrangeCoins2(int n) {
        int left = 1 , right = n ;
        while (left < right){
            int mid = left + (right - left + 1 ) / 2 ;
            long mul = ((long)(mid)*(mid+1))/2;
            if(mul <= n){
                left = mid ;
            }else {
                right = mid - 1 ;
            }
        }
        return left;
    }
    @Test
    public void test(){
        int ans = arrangeCoins(5);
    }
}
