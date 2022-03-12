package middle;

public class Offer_64 {
    //剑指 Offer 64. 求1+2+…+n
    /*
    * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    * */
    public int sumNums(int n) {
        return (n * ( n + 1)) >> 1 ;
    }
    public int sumNums1(int n) {
        boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0 ;
        return n ;
    }
    public int sumNums2(int n) {
        int ans = 0, A = n, B = n + 1;
        boolean flag;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        flag = ((B & 1) > 0) && (ans += A) > 0;
        A <<= 1;
        B >>= 1;

        return ans >> 1;
    }
    public int sumNums3(int n) {
        int ans = 0 , a = n , b = n + 1 ;
        boolean flag ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;

        flag = (b & 1) == 1 && (ans += a) > 0;
        a <<= 1 ;
        b >>= 1 ;
        return ans >> 1 ;
    }
}


















