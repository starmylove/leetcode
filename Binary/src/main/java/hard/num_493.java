package hard;

import org.junit.Test;

import java.util.Arrays;

public class num_493 {
    public int reversePairs(int[] nums) {
        return counts(nums, 0, nums.length - 1);
    }
    public int counts(int[] nums, int start, int end){
        int ans = 0;
        if(start < end){
            int mid = (start + end) / 2;
            ans += counts(nums, start, mid) + counts(nums, mid + 1, end);
            int j = mid + 1;
            for(int i = start; i <= mid; i ++){
                while(j <= end && (long)(nums[j]) * 2 < nums[i]){
                    j ++;
                }
                ans += j - mid - 1;
            }
            Arrays.sort(nums, start, end + 1);
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
