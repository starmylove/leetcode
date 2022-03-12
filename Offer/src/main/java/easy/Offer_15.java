package easy;

import org.junit.Test;

public class Offer_15 {
    /*位运算
    * 请实现一个函数，输入一个整数（以二进制串形式），
    * 输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，
    * 有 2 位是 1。因此，如果输入 9，则该函数输出 2。
    * */
    public int hammingWeight(int n) {
        int ans = 0 ;
        while(n!=0){
            ans += n&1;
            n=n>>>1;
        }
        return ans;
    }
    public int hammingWeight1(int n) {
        int ans = 0 ;
        while(n!=0){
            ans += 1;
            n = n&(n-1);
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println("java 右移");
        Integer a = -5;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(a >> 2)); // 有符号右移
        System.out.println(Integer.toBinaryString(a >>> 2)); // 无符号右移

//        java 右移
//        11111111111111111111111111111011
//        11111111111111111111111111111110
//        111111111111111111111111111110      注：前边的两个0被省略了


        System.out.println("java 负数 左移");
        Integer b = Integer.MIN_VALUE;
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(b << 2));
//      java 负数 左移
//      10000000000000000000000000000000
//      0                                  注：不保留符号位，符号位直接移走

        System.out.println("java 正数 左移");
        Integer c = 5;
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(c << 2));
//      java 正数 左移
//      101
//      10100

    }
}
