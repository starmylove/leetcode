package middle;

import javax.management.loading.MLet;

public class Offer_66 {
    //剑指 Offer 66. 构建乘积数组
    /*
    *
    * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
    * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
    * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
*/
    public int[] constructArr(int[] a) {
        int n = a.length;
        if(n == 0) {
            return new int[0];
        }
        int[] ans = new int[n];
        ans[0] = 1 ;
        for (int i = 1; i < n; i++) {
            ans[i] = a[i-1] * ans[i-1];
        }
        int mul = 1;
        for (int i = n - 2; i >= 0; i--) {
            mul *= a[i+1];
            ans[i] *= mul;
        }
        return ans;
    }
}
