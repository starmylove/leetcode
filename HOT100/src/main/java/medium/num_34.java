package medium;

public class num_34 {
    public int[] searchRange1(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int l = 0 , r = nums.length - 1 ;
        //先找最左侧的
        while(l < r){
            int mid = (l + r) >> 1 ;
            if(nums[mid] < target){
                l = mid + 1 ;
            }else if( nums[mid] > target){
                r = mid - 1 ;
            }else {
                if(mid == l || nums[mid-1] < target){
                    l = mid ;
                    break;
                }
                r = mid - 1 ;
            }
        }
        if(nums[l] != target){
            return new int[]{-1,-1};
        }
        int ll = l ;
        l = 0 ;
        r = nums.length - 1 ;
        while(l < r){
            int mid = ((l + r) >> 1) + 1;
            if(nums[mid] < target){
                l = mid + 1 ;
            }else if( nums[mid] > target){
                r = mid - 1 ;
            }else {
                if(mid == r || nums[mid+1] > target){
                    r = mid ;
                    break;
                }
                l = mid ;
            }
        }
        return new int[]{ll,r};
    }
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        return new int[]{findLeft(nums,target),findRight(nums,target)};
    }

    private int findLeft(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1 ;
            if(nums[mid] < target){
                l = mid + 1 ;
            }else if(nums[mid] > target){
                r = mid - 1 ;
            }else if(nums[mid] == target){
                r = mid - 1 ;
            }
        }
        return l < nums.length && nums[l] == target  ? l : -1 ;
    }

    private int findRight(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) >> 1 ;
            if(nums[mid] < target){
                l = mid + 1 ;
            }else if(nums[mid] > target){
                r = mid - 1 ;
            }else if(nums[mid] == target){
                l = mid + 1 ;
            }
        }
        return r >= 0  && nums[r] == target  ? r : -1 ;
    }
}
