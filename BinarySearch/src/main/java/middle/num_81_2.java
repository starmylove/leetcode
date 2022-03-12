package middle;

import org.junit.Test;

public class num_81_2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length , l = 0 , r = n - 1 ;
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return nums[0] == target ;
        }
        while (l <= r){
            int mid = (l + r )>>1;
            if(nums[mid] == target){
                return true ;
            }else if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            }else if(nums[mid] >= nums[l]){
                if(target >= nums[l] && target < nums[mid]){
                    r = mid - 1 ;
                }else {
                    l = mid + 1;
                }
            }else if(nums[mid + 1] <= nums[r]){
                if(target >= nums[mid + 1 ] && target <= nums[r]){
                    l = mid + 1 ;
                }else {
                    r = mid - 1 ;
                }
            }
        }
        return false;
    }
    @Test
    public void test(){
        search(new int[]{1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1},13);
    }
}
