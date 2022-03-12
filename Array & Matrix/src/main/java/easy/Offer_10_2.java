package easy;

public class Offer_10_2 {
    /*
    * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。
    * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
      答案需要取模 1e9+7（1000000007），
      如计算初始结果为：1000000008，请返回 1。
    * */
    public static void main(String[] args) {
        int ans = numWays(2000000);
        System.out.println(ans);
    }

    public static int numWays(int n) {
        if(n==2||n==1) {
            return n;
        }
        int a = 1 , b = 2 , c = 0 ;
        for (int i = 2; i < n; i++) {
            c=(a+b)%1000000007;
            a=b%1000000007;
            b=c%1000000007;
        }
        return c;
    }
}
