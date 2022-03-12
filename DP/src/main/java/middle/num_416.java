package middle;

public class num_416 {
    //416. 分割等和子集
    /*
    * 给你一个只包含正整数的非空数组 nums
    * 请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
    * */
    public boolean canPartition(int[] nums) {
        //该问题下，每样物品的价值等于重量，所以，设置背包最大容量为sum/2，看最大价值能否达到sum/2，正好装满背包
        int sum = 0 , n = nums.length;
        for(int num : nums) {
            sum += num ;
        }
        if((sum&1) ==1) {
            return false ;
        }
        int target =  (sum >> 1);
        int[] dp = new int[target+1] ;
        for (int i = target; i >= nums[0]; i--) {
            dp[i] = nums[0] ;
        }
        for (int i = 1; i < n; i++) {
            int t = nums[i];
            for (int j = target ; j >= t ; j--) {
                int x = dp[j] ;
                int y = t + dp[j-t];
                dp[j] = Math.max(x,y);
            }
        }
        return dp[target] == target ;
    }
}
