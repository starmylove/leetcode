package hard;

import org.junit.Test;

public class num_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i]<=0){
                nums[i] = n+1;
            }
        }
        for (int i = 0; i < n; i++) {
            int value = Math.abs(nums[i]);
            if(value<=n && nums[value-1]>0){
                nums[value-1] = -nums[value-1];
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i]>0) {
                return i+1;
            }
        }
        return n+1;
    }
    @Test
    public void test(){
        int[] nums = new int[]{3,4,-1,1};
        int i = firstMissingPositive((nums));
        System.out.println(i);
    }
}
