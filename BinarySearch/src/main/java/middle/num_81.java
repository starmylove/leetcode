package middle;

import org.junit.Test;

public class num_81 {
    //81. 搜索旋转排序数组 II
    /*
    * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
    * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
    * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
    * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。
    * 如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
    * */
    public boolean search(int[] nums, int target) {
        int n = nums.length , l = 0 , r = n - 1 ;
        if(n == 1){
            return target == nums[0];
        }
        while (nums[r] == nums[l]){
            r--;
        }
        while (l<r){
            int mid= (l + r) >> 1 ;
            if(nums[mid] <= nums[r]){
                r = mid - 1 ;
            }else if(nums[mid] >= nums[l] && nums[mid+1] > nums[mid]){
                l = mid + 1 ;
            }else {
                l = mid ;
                break;
            }
        }
        return binarySearch(nums,0 , l ,target) || binarySearch(nums,l+1 ,n-1 ,target);
    }

    private boolean binarySearch(int[] nums, int l, int r,int target) {
        while (l <= r){
            int mid = (l + r) >> 1 ;
            if(nums[mid] > target){
                r = mid - 1 ;
            }else if(nums[mid] < target){
                l = mid + 1 ;
            }else {
                return true;
            }
        }
        return false;
    }
    @Test
    public void test(){
        search(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1},2);
    }
}
