package medium;

import org.junit.Test;

public class num_75 {
    public void sortColors(int[] nums) {
        int red = 0 , blue = nums.length - 1 ;
        for (int i = 0; i < blue; i++) {
            while(i < blue && nums[i] == 2){
                swap(nums,i,blue--);
            }
            if(nums[i] == 0){
                swap(nums,red++,i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }

    @Test
    public void test(){
        sortColors(new int[]{2,0,1});
    }
}
