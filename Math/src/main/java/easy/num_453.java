package easy;

import java.util.Arrays;

public class num_453 {
    public int minMoves(int[] nums) {
        if(nums.length==1) {
            return 0;
        }
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i]+=-min;
        }
        int sum = 0 ;
        for (int i : nums){
            sum+=max-i;
        }
        int ans = 0 ;
        int n = nums.length;
        ans += sum/(n-1);
        sum = sum%(n-1);
        if(sum==0) {
            return ans;
        }
        ans++;
        int x = n-1-sum;
        return ans + x ;
    }
}
