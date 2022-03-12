package middle;

import org.junit.Test;

public class num_238 {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length , mul = 1 ,temp = nums[length-1];
        int[] left = new int[length] ;
        left[0] = 1 ;
        for (int i = 1; i < length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }
        for (int i = length-2; i >= 0 ; i--) {
            mul *= temp;
            temp = nums[i];
            nums[i]=mul;
        }
        nums[length-1]=1;
        for (int i = 0; i < length; i++) {
            left[i]*=nums[i];
        }
        return left;
    }
    @Test
    public void test(){
        int[] nums = new int[]{1,2,3,4};
        int[] ints = productExceptSelf(nums);

    }
}
