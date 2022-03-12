package easy;

import org.junit.Test;

public class num_283 {
    //283. 移动零
    /*
    * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    * */
    public void moveZeroes(int[] nums) {
        int zeros = 0 , n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0 ){
                zeros++;
                continue;
            }
            nums[i-zeros] = nums[i];
        }
        for (int i = n-1; i >=n-zeros ; i--) {
            nums[i]=0;
        }
    }
    @Test
    public void test(){
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
