package medium;

import org.junit.Test;

public class num_33 {
    public int search(int[] nums, int target) {
        int l = 0 , r = nums.length - 1 ;
        while(l < r){
            int mid = ((l + r) >> 1 )+ 1;
            //左半部分有序
            if(nums[l] <= nums[mid-1]){
                //target在左侧数组
                if(nums[l] <= target && target <= nums[mid-1]){
                    r = mid - 1 ;
                }else{
                    l = mid ;
                }
            }else{//右半部分有序
                //target在右侧数组
                if(nums[mid] <= target && target <= nums[r]){
                    l = mid ;
                }else{
                    r = mid - 1 ;
                }
            }
        }
        if(nums[l] == target){
            return l ;
        }else{
            return -1;
        }
    }
    @Test
    public void test(){
        search(new int[]{4,5,6,7,0,1,2},4);
    }
}
