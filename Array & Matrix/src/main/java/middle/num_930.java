package middle;

import java.util.HashMap;
import java.util.Map;

public class num_930 {
    //930. 和相同的二元子数组
    /*
    * 给你一个二元数组 nums ，和一个整数 goal ，
    * 请你统计并返回有多少个和为 goal 的 非空 子数组。子数组 是数组的一段连续部分。
    * */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int preSum = 0 , count = 0 ;
        for(int x : nums){
            preSum += x ;
            if(map.containsKey(preSum - goal)){
                count += map.get(preSum -goal) ;
            }
            map.put(preSum,map.getOrDefault(preSum,0) + 1 );
        }
        return count;
    }
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int total = 0 ,preSum = 0 ,ans = 0 ;
        for(int num : nums) {
            total += num ;
        }
        if(total == 0 && goal == 0){
            int n = nums.length;
            return (n * ( n + 1 )) >> 1 ;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 1 ;
        for (int x : nums) {
            preSum += x ;
            if(preSum >= goal) {
                ans += dp[preSum - goal];
            }
            dp[preSum] ++ ;
        }
        return ans ;
    }
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if (total == 0 && goal == 0) {
            int res = 0;
            res = (1 + nums.length) * nums.length;
            return res >> 1;
        }
        int[] dp = new int[nums.length + 1];
        //Arrays.fill(dp, -1);
        dp[0] = 1;
        int res = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= goal) {
                res += dp[sum - goal];
            }
            dp[sum]++;
        }
        return res;
    }
}
