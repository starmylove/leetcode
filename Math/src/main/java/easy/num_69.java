package easy;

import org.junit.Test;

public class num_69 {
    public int mySqrt(int x) {
        int l = 0 , r = Integer.MAX_VALUE;
        while(l < r){
            int mid = l + ((r - l) >> 1) ;
            long num =  ((long)mid * mid) ;
            if(num == x) {
                return mid;
            }
            if(num < x){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        long num =  ((long)l * l) ;
        return num<=x?l:l-1;
    }
    @Test
    public void test(){
        int i = mySqrt(8);
        System.out.println(i);
    }
}
