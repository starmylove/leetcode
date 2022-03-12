package easy;

import org.junit.Test;

import java.util.Arrays;

public class num_414 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3) {
            return nums[nums.length-1];
        }
        int count = 1 , i ;
        for (i = nums.length - 2 ; i >= 0 && count != 3; i --) {
            if(nums[i]!=nums[i+1]) {
                count++;
            }
            if(count==3) {
                break;
            }
        }
        if( count < 3 ) {
            return nums[nums.length-1] ;
        }
        return nums[i] ;
    }
    @Test
    public void test(){
        int[] nums = new int[]{1};
        int i = thirdMax(nums);
        System.out.println(i);
    }
}
