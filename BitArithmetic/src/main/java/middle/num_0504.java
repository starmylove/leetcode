package middle;

import org.junit.Test;

public class num_0504 {
    public int[] findClosedNumbers(int num) {
        int[] ans = new int[2];
        if(num == 1){
            ans[1]=-1;
            ans[0]=2;
            return ans;
        }
        if(num == Integer.MAX_VALUE){
            ans[0] = -1;
            ans[1] = -1;
            return ans;
        }
        //smaller
        if((num & 1) == 0) {
            ans[1] =(num&( num - 1)) +1;
        } else {
            int rev = ~num ;
            int z = rev & (rev - 1);
            int x = rev - z , xx = x;
            x >>= 1 ;
            x |= (x >> 1);
            x |= (x >> 2);
            x |= (x >> 4);
            x |= (x >> 8);
            x |= (x >> 16);
            int y = num - x ;
            y = y - (y & (y-1));
            ans[1] = num - y + xx ;
        }
        //greater
        if((num&1)==1){
            int rev = ~num ;
            int z = rev & (rev - 1);
            int x = rev - z ;
            ans[0] = num + x - 1 ;
        }else {
            int counts = 0 ;
            while ((num&1)!=1){
                num >>= 1;
                counts++;
            }
            int rev = ~num ;
            int z = rev & (rev - 1);
            int x = rev - z ;
            ans[0] = num + x - 1 ;
            for (int i = 0; i < counts; i++) {
                ans[0] <<= 1 ;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(~Integer.MAX_VALUE);
    }
}
