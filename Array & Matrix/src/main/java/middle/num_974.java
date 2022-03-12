package middle;

import java.util.HashMap;
import java.util.Map;

public class num_974 {
    //974. 和可被 K 整除的子数组
    /*
    * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
    *

    1 <= A.length <= 30000
    -10000 <= A[i] <= 10000
    2 <= K <= 10000

    * */
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0 , preSum = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int x : nums ){
            preSum += x ;
            int key = (preSum % k + k) % k ;
            if(map.containsKey( key )){
                ans += map.get(key);
            }
            map.put(key,map.getOrDefault(key,0)+1);
        }
        return ans ;
    }
}









































