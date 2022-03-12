package middle;

import java.util.HashMap;
import java.util.Map;

public class num_1248 {
    //1248. 统计「优美子数组」
    /*
    * 给你一个整数数组 nums 和一个整数 k。
    * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
    * 请返回这个数组中「优美子数组」的数目。
    * */
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0 ;
        map.put(0,1) ;
        int preSum = 0 ;
        for (int x : nums){
            preSum += (x & 1) ;
            if(map.containsKey(preSum - k)){
                ans += map.get(preSum - k) ;
            }
            map.put(preSum,map.getOrDefault(preSum,0)+1);
        }
        return ans;
    }
}
