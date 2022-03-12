package middle;

import java.util.HashMap;
import java.util.Map;

public class num_523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        int preSum = 0 , count = 0 ;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        for (int i = 0; i <nums.length - 1 ; i++) {
            preSum += nums[i];
            int key = (preSum + nums[i + 1]) % k ;
            if(map.containsKey(key)){
                return true;
            }
            map.put(preSum  % k,map.getOrDefault(preSum % k,0)+1) ;
        }
        return false;
    }
    public boolean checkSubarraySum1(int[] nums, int k) {
        if(nums.length==1) {
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum += nums[j];
                if(sum%k==0){
                    return true;
                }
            }
            if(sum < k){
                break;
            }
        }
        return false;
    }
}




















