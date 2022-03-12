package easy;

import org.junit.Test;

public class num_190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int x = 0;
        for (int i = 0; i < 32; i++) {
            if((n&1)==1) {
                x++;
            }
            if(i!=31){
                x = x<<1;
                n = n>>1;
            }
        }
        return x;
    }
    public int reverseBits2(int n) {
        //官方题解方法1
        int x = 0;
        for (int i = 0; i < 32; i++) {
            x |= (n&1)<<31-i;
            n>>>=1;
        }
        return x;
    }
    public int reverseBits3(int n){
        //官方题解方法2，分治法
        int M1 = 0x55555555;//01010101010101010101010101010101
        int M2 = 0x33333333;//00110011001100110011001100110011
        int M3 = 0x0f0f0f0f;//00001111000011110000111100001111
        int M4 = 0x00ff00ff;//00000000111111110000000011111111
        n = (n&M1)<<1 | n>>>1&M1;
        n = (n&M2)<<2 | n>>>2&M2;
        n = (n&M3)<<4 | n>>>4&M3;
        n = (n&M4)<<8 | n>>>8&M4;
        return n<<16 | n>>>16;
    }
    @Test
    public void test(){
        long ans = Integer.parseInt("01000010100101000001111010011100",2);
        //  1928352384 (01110010111100000101001010000000)
        //   964176192 (00111001011110000010100101000000)
        int temp = (int)ans;
        System.out.println(Integer.toBinaryString(temp));
        ans = reverseBits((int)ans);
        System.out.println(ans);
    }


    @Test
    public void test1(){
        int a = 8 ;
        int c = ~(a-1);
        int b = a & (-a) ;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(c));
        System.out.println(Integer.toBinaryString(-a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.bitCount(15));

    }

}
