package middle;

import org.junit.Test;

public class Offer_65 {
    public int add(int a, int b) {
        boolean flag = false ;
        int ans = 0 ,curNum = 1;
        for (int i = 0; i < 32; i++) {
            boolean isA = (a & curNum) == curNum;
            boolean isB = (b & curNum) == curNum;
            if(!isA && !isB){
                if(flag){
                    ans |= curNum ;
                    flag = false ;
                }
            }else if (isA && isB){
                if(flag){
                    ans |= curNum ;
                }
                flag = true   ;
            }else if(isA){
                if(!flag){
                    ans |= curNum ;
                }
            }else if(isB){
                if(!flag){
                    ans |= curNum ;
                }
            }
            curNum <<= 1 ;
        }
        return ans ;
    }
    public int add1(int a, int b) {
        while(b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
    public int add2(int a, int b) {
        if (b == 0) {
            return a;
        }
        // 转换成非进位和 + 进位
        return add(a ^ b, (a & b) << 1);
    }
    @Test
    public void test(){
        System.out.println(add(111, 899));
    }
}
