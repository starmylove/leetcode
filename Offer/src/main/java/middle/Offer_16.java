package middle;

import org.junit.Test;

public class Offer_16 {


    public double myPow(double x, int n) {
        /*
        * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
        * 不得使用库函数，同时不需要考虑大数问题
        * */
        if(x==1.0) {
            return 1;
        }
        if(x==-1.0) {
            return n%2==0?1:-1;
        }
        if(n==0) {
            return 1;
        }
        if(n>0){
            double ans = 1 ;
            while(n!=0){
                ans *= x;
                n --;
            }
            return ans;
        }else{
            double ans = 1 ;
            while(n!=0){
                ans /= x;
                if(ans==0.0) {
                    return 0;
                }
                n ++;
            }
            return ans;
        }
    }


    public double myPow1(double x, int n) {
        //递归的方法，避免重复计算
       if(n<0) {
           return 1 / (x * myPow(x, - n - 1));
       } else if(n==0) {
           return 1;
       } else if((n&1)==1) {
           return x*myPow1(x,n-1);
       } else {
           return myPow1(x*x,n>>1);
       }

    }

    public double myPow2(double x, int n){
        //快速幂
        if(x==0) {
            return 0;
        }
        if(x==1.0) {
            return 1;
        }
        if(x==-1.0) {
            return n%2==0?1:-1;
        }
        if(n==0) {
            return 1;
        }
        if(n==1) {
            return x;
        }
        double ans = 1;
        long b = n;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b>0){
            if((b&1)==1) {
                ans *= x;
            }
            x*=x;
            b=b>>1;
        }
        return ans;
    }
    @Test
    public void test(){
        double ans = myPow2(2.0,-2147483648);
        System.out.println(ans);
    }
    @Test
    public void test1(){
        int a =-1;
        for (int i = 0; i < 31; i++) {
            a*=2;
        }
        System.out.println(-a-1);
    }
}
