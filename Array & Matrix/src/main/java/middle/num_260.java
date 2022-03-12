package middle;

import org.junit.Test;

public class num_260 {
    public int[] singleNumber(int[] nums) {
        int n = nums.length ;
        int x = 0 ;
        for(int num : nums){
            x ^= num ;
        }
        int lowbit = (x == Integer.MIN_VALUE ? x : x & - x ) ,ans1 = x , ans2 = x ;
        for(int num : nums){
            if((num & lowbit) == lowbit) {
                ans1 ^= num ;
            }
        }
        for(int num : nums){
            if((num & lowbit) == 0) {
                ans2 ^= num ;
            }
        }
        return new int[]{ans1,ans2};
    }
    @Test
    public void test(){
        singleNumber(new int[]{1,1,2,2,3,5});
    }
}
