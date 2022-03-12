package middle;

import org.junit.Test;

public class num_33 {
    public int search(int[] nums, int target) {
        //先找出两段数组的首尾下标
        int length = nums.length;
        int left = 0 , right = length - 1 ;
        int mid = 0;
        while (left<right){
            mid = (left + right) / 2;
            if((mid > 0 && nums[mid] < nums[ mid - 1 ]) || ( mid < length - 1 && nums[ mid ] > nums[ mid + 1 ])) {
                break;
            }
            if(nums[mid]>nums[left]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        int lr =0, rl =0;
        if(mid > 0 && nums[mid] < nums[ mid - 1 ]){
            rl = mid;
            lr = mid - 1 ;
        }
        if(mid < length-1 && nums[mid] > nums[ mid + 1 ]){
            rl = mid + 1;
            lr = mid ;
        }
        int ans = -1 ;
        if(target<=nums[length-1]&&target>=nums[rl]) {
            ans = binarySearch(nums,rl,length-1,target);
        }
        if(target<=nums[lr]&&target>=nums[0]) {
            ans = binarySearch(nums,0,lr,target);
        }
        return ans;

    }
    public int binarySearch(int[] nums , int left , int right , int target){
        int mid ;
        while (left<=right){
            mid = (left + right)/2;
            if(target==nums[mid]) {
                return mid;
            }
            if(target>nums[mid]) {
                left = mid + 1 ;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }




    @Test
    public void test(){
        int[] nums = new int[]{5,1,2,3,4};
        int search = search(nums, 5);
        System.out.println(search);
    }
}
