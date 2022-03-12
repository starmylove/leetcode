package middle;

import org.junit.Test;

public class Offer_14_1 {
    /*
    * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
    * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
    * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
    * */
    @Test
    public void test(){
        int ans = cuttingRope1(50);
        System.out.println(ans);
    }
    public int cuttingRope(int n) {
        //对于每根绳子，考虑减或不减，看谁的长度乘积大，依此来决定是否裁剪
        int[] multi = new int[n+1];
        multi[1]=1;
        for (int i = 2; i <= n; i++) {
            int max = 0 ;
            for(int j = 1 ; j <=i/2 ; j++) {
                max = max>multi[j]*multi[i-j]?max:multi[j]*multi[i-j];
            }
            multi[i] = max>i?max:i;
        }
        int ans = 0 ;
        for(int i = 1 ; i <= n/2 ;i++) {
            ans = ans>multi[i]*multi[n-i]?ans:multi[i]*multi[n-i];
        }
        return ans;
    }
    public int cuttingRope1(int n){
        if(n==2) {
            return 1;
        }
        if(n==3) {
            return 2;
        }
        int[] m = new int[n+1];
        m[1] = 1 ;
        m[2] = 2 ;
        m[3] = 3 ;
        for (int i = 4; i <= n; i++) {
            int max = 0 ;
            for(int j = 1 ; j <=i/2 ; j++) {
                max = max>m[j]*m[i-j]?max:m[j]*m[i-j];
            }
            m[i] = max;
        }
        return m[n];
    }
    public int cuttingRope2(int n){
        //贪心
        if(n<3) {
            return 1;
        }
        if(n==3) {
            return 2;
        }
        int res = 1 ;
        while(n>4){
            res *= 3;
            n -=3;
        }
        return n*res;
    }
}
