package middle;

public class num_153 {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int n = nums.length , l = 0 , r = n - 1 ;
        if (n == 1) {
            return nums[0] ;
        }
        while (l <= r){
            int mid = (l + r )>>1;
            min = Math.min(min,nums[mid]);
            if(nums[mid] >= nums[l]){
                min = Math.min(min,nums[l]);
                l = mid + 1 ;
            }else if(nums[mid + 1] <= nums[r]){
                min = Math.min(min,nums[r]);
                r = mid - 1 ;
            }
        }
        return min;
    }
}
