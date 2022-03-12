package easy;

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

public class num_66 {
    public int[] plusOne(int[] digits) {
         int n = digits.length , index = n - 1 ;
         boolean flag = true;
         while (flag){
             if(digits[index]<9){
                 digits[index]++;
                 flag=false;
             }else {
                 digits[index--]=0;
                 if(index==-1){
                     break;
                 }
             }
         }
         if(!flag) {
             return digits;
         } else {
             int[] ans = new int[n+1];
             ans[0] = 1 ;
             for (int i = 1; i < n+1; i++) {
                 ans[i] = digits[i-1];
             }
             return ans;
         }
    }
    @Test
    public void test(){
        int[] digits = new int[]{9,9};
        int[] ints = plusOne(digits);

    }
}
