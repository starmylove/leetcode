package middle;

import org.junit.Test;

import java.lang.annotation.ElementType;

public class num_29 {
    //此题必须在负数空间上做运算
    //如果想判断 2 A > B ? 担心2A溢出，可以用 A > B - A ?
    public int divide(int dividend, int divisor) {
        if(divisor==1) {
            return dividend;
        }
        if(dividend == Integer.MIN_VALUE&&divisor == -1){
            return Integer.MAX_VALUE;
        }
        if(divisor == Integer.MIN_VALUE){
            if(dividend == divisor) {
                return 1;
            } else {
                return 0;
            }
        }
        if(dividend==0) {
            return 0;
        }
        boolean flag = false ;
        if(dividend>0&&divisor>0){
            dividend=-dividend;
            divisor=-divisor;
        }
        if(dividend>0 || divisor>0){
            flag=true;
            if(dividend>0) {
                dividend=-dividend;
            } else {
                divisor=-divisor;
            }
        }
        if(dividend > divisor) {
            return 0;
        }
        int l = 1 , r = Integer.MAX_VALUE ;
        while (l<r){
            int mid = l + ((r - l)>>1) ;
            if(quickAdd(dividend,divisor,mid)){
                l = mid + 1 ;
            }else {
                r = mid - 1 ;
            }
        }
        if(!quickAdd(dividend,divisor,r)) {
            r--;
        }
        return flag?-r:r;
    }
    public boolean quickAdd(int x , int y , int z){
        //此函数用于判断    z * y >= x ?
        int result = 0 , add = y;
        while (z != 0){
            if ((z & 1) != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false;
                }
                result += add;
            }
            if (z != 1) {
                // 需要保证 add + add <= x
                if (add < x - add) {
                    return false;
                }
                add += add;
            }
            // 不能使用除法
            z >>= 1;
        }
        return true;
    }
    @Test
    public void test(){
        int divide = divide(-2147483648, 2147483647);
        System.out.println(divide);
    }
}
