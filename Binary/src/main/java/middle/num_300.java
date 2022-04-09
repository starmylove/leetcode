package middle;

import org.junit.Test;

public class num_300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] sub = new int[n];
        sub[0] = nums[0];
        int len = 1;
        for(int i = 1; i < n; i ++) {
            if(nums[i] < sub[len - 1]) {
                int index = 0, l = 0, r = len - 1;
                while(l <= r) {
                    int mid = (l + r) / 2;
                    if(sub[mid] >= nums[i]){
                        index = mid;
                        r = mid - 1;
                    }else {
                        l = mid + 1;
                    }
                }
                sub[index] = nums[i];
            }else if(nums[i] > sub[len - 1]){
                sub[len ++] = nums[i];
            }
        }
        return len;
    }
    @Test
    public void test(){
        lengthOfLIS(new int[]{18,55,66,2,3,54});
    }
}
