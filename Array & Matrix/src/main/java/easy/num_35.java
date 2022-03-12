package easy;

import org.junit.Test;

public class num_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length - 1 , mid ;
        while (left <= right){
            mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(target>nums[mid]){
                left = mid + 1 ;
            }else {
                right = mid - 1 ;
            }
        }
        return left;
    }
    @Test
    public void test(){
        int i = searchInsert(new int[]{}, 10);
        System.out.println(i);
    }
}
