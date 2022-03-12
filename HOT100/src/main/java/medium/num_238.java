package medium;

public class num_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n], right = new int[n] ;
        left[0] = 1 ;
        right[n-1] = 1 ;
        for (int i = 1; i < n; i++) {
            left[i] = nums[i-1] * left[i-1];
            right[n-1-i] = nums[n-i] * right[n-i];
        }
        for (int i = 0; i < n; i++) {
            left[i] *= right[i];
        }
        return left;
    }
    //空间优化
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n] ;
        ans[0] = 1 ;
        int right = 1 ;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        for (int i = n-1; i >= 0; i--) {
            ans[i] *= right;
            right *= nums[i];
        }
        return ans;
    }
}
