package easy;

import org.junit.Test;

public class num_231 {
    /*
     * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。
     * 如果是，返回 true ；否则，返回 false 。
     * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
     * */

    //n&(n-1)
    public boolean isPowerOfTwo(int n) {
        return (n>0)&&(n&(n-1))==0;
    }


    //判断是否为最大2^31的幂的约数
    private static final int BIG = 1<<30;
    public boolean isPowerOfTwo1(int n) {
        return true;
    }


    //lowbit
    public int lowbit(int x){
        return x&(-x);
    }
    @Test
    public void testLowbit(){
        int lowbit = lowbit(32);
        System.out.println(lowbit);
    }
    @Test
    public void test(){
        int n = Integer.MAX_VALUE;
        Integer x = n;
        System.out.println();
        System.out.println(~BIG);
        System.out.println(BIG);
        System.out.println(isPowerOfTwo(n));
    }
}
