package middle;

import org.junit.Test;

public class num_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0 , right = nums.length - 1 , mid = 0;
        while (left  <= right){
            mid = (left + right)/2;
            if(target==nums[mid]) {
                break;
            }
            if(target>nums[mid]) {
                left = mid + 1 ;
            } else {
                right = mid-1;
            }
        }
        if(left>right) {
            return new int[]{-1,-1};
        }
        left = mid;
        right = mid;
        while (left>0&&nums[left-1]==target) {
            left--;
        }
        while (right<nums.length-1 && nums[right+1]==target) {
            right++;
        }
        return new int[] {left,right};
    }
    @Test
    public void test(){
        int[] nums = new int[]{8};
        int[] search = searchRange(nums, 8);
        System.out.println(search[0]);
        System.out.println(search[1]);
    }
}