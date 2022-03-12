package middle;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num_560 {
    //560. 和为 K 的子数组
    /*
    * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
    * */
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int preSum = 0 , ans = 0;
        map.put(0,1);
        for(int x : nums){
            preSum += x;
            if(map.containsKey(preSum-k)){
                ans += map.get(preSum-k);
            }
            map.put(preSum,1+map.getOrDefault(preSum,0));
        }
        return ans ;
    }
    @Test
    public void test(){
        System.out.println(subarraySum(new int[]{1,1,1}, 2));
    }
}
















