package middle;

import org.junit.Test;

public class num_29 {
    //29. 两数相除
    /*
    * 给定两个整数，被除数 dividend 和除数 divisor。
    * 将两数相除，要求不使用乘法、除法和 mod 运算符。
    * 返回被除数 dividend 除以除数 divisor 得到的商。
    * 整数除法的结果应当截去（truncate）其小数部分，
    * 例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
    * */
    public int divide(int a, int b) {
        long x = a, y = b;
        boolean isNeg = false;
        if ((x > 0 && y < 0) || (x < 0 && y > 0)) {
            isNeg = true;
        }
        if (x < 0) {
            x = -x;
        }
        if (y < 0) {
            y = -y;
        }
        long l = 0, r = x;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mul(mid, y) <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        long ans = isNeg ? -l : l;
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int)ans;
    }
    long mul(long a, long k) {
        long ans = 0;
        while (k > 0) {
            if ((k & 1) == 1) {
                ans += a;
            }
            k >>= 1;
            a += a;
        }
        return ans;
    }

    @Test
    public void test(){
        int divide = divide(9, 2);
        System.out.println(divide);
    }

}
