package easy;

public class OfferII_72 {

    /*
    * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
    * 正数的平方根有两个，只输出其中的正数平方根。如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。
    * */
    public int mySqrt(int x) {
        if(x <= 1) {
            return x ;
        }
        long xx = x ;
        int l = 1 , r = (int)Math.sqrt(Integer.MAX_VALUE)+1;
        while (l < r){
            int mid = ((l + r) >> 1 ) + 1;
            if( (long)mid * mid > xx){
                r = mid - 1 ;
            }else {
                l = mid ;
            }
        }
        return r ;
    }
}
