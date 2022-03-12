package medium;

public class num_300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1 ;
        int ans = 1 ;
        for (int i = 1; i < nums.length; i++) {
            int max = 0 ;
            for(int j = 0 ; j < i ; j ++){
                if(nums[i] > nums[j]){
                    max = Math.max(max,dp[j]);
                }
            }
            dp[i] = max + 1 ;
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
    public int lengthOfLIS1(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int len = 1 ;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > dp[len]){
                len ++ ;
                dp[len] = nums[i] ;
                continue;
            }
            int target = nums[i];
            int l = 1 , r = len , pos = 0;
            while(l <= r){
                int mid = (l + r) >> 1 ;
                if(dp[mid] < target){
                    pos = mid ;
                    l = mid + 1 ;
                }else {
                    r = mid - 1 ;
                }
            }
            dp[pos + 1] = nums[i];
        }
        return len;
    }
    public int firstMinIndex(int[] nums,int targrt){
        int pos = - 1 ;
        int l = 0 , r = nums.length ;
        while (l <= r){
            int mid = (l + r) >> 1 ;
            if(nums[mid] < targrt){
                l = mid ;
                pos = l ;
            }else {
                r = mid - 1 ;
            }
        }
        return pos + 1 ;
    }
}
