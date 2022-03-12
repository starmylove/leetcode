package middle;

public class num_45 {
    /*
    *   给定一个非负整数数组，你最初位于数组的第一个位置。
        数组中的每个元素代表你在该位置可以跳跃的最大长度。
        你的目标是使用最少的跳跃次数到达数组的最后一个位置。
        假设你总是可以到达数组的最后一个位置。
    * */
    //贪心
    public int jump2(int[] nums) {
        int ans = 0 ;
        int end = 0 ;
        int maxPos = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxPos = Math.max(maxPos,i+nums[i]);
            if(i==end){
                end = maxPos;
                ans ++;
            }
        }
        return ans;
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 0 ;
        int right = 1 ;
        int index ;
        for ( index = 0; index < length-1; index++) {
            if(right>index + nums[index]) {
                continue;
            }
            int max = Math.min(index + nums[index] ,length-1);
            if(max>=length) {
                return dp[index]+1;
            }
            for (int i = right; i <= max ; i++) {
                if(dp[i]==0) {
                    dp[i] = dp[index] + 1;
                }
            }
            right = right<=max?max+1:right;
        }
        return dp[length-1];
    }
}
