package middle;

import org.junit.Test;

public class num_540 {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, ans = 0;
        while(l < r){
            int mid = (l + r) >> 1;
            if((mid & 1) == 1){
                if(nums[mid] == nums[mid - 1]){
                    l = mid + 1;
                }else{
                    r = mid;
                }
            }else{
                if(nums[mid] == nums[mid + 1]){
                    l = mid + 2;
                }else{
                    r = mid;
                }
            }
        }
        return r;
    }
    @Test
    public void test(){
        int i = singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11});
    }
}
