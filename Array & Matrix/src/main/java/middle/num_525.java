package middle;

import org.junit.Test;

import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class num_525 {
    public int findMaxLength(int[] nums) {
        if(nums.length==1) {
            return 0;
        }
        int preSum = 0 , max = 0 ;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i]==1 ? 1 : -1) ;
            if(map.containsKey(preSum)){
                max = Math.max(max,i - map.get(preSum));
            }
            if(!map.containsKey(preSum)){
                map.put(preSum,i);
            }
        }
        return max ;
    }
    public int findMaxLength1(int[] nums) {
        int max = Integer.MIN_VALUE , min = Integer.MAX_VALUE , sum = 0;
        for(int x : nums){
            sum += (x==1 ? 1 : -1) ;
            max = Math.max(max,sum);
            min = Math.min(min,sum);
        }
        int length = max - min + 1 ;
        int[] dp = new int[length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        if(max >= 0 && min <= 0) {
            dp[-min] = -1 ;
        }
        int ans = 0 , preSum = 0 ;
        for (int i = 0; i < nums.length; i++) {
            preSum += (nums[i]==1 ? 1 : -1) ;
            if(dp[preSum-min] != Integer.MAX_VALUE){
                ans = Math.max(ans,i - dp[preSum-min]);
            }else {
                dp[preSum-min] = i ;
            }
        }
        return ans ;
    }
    @Test
    public void test(){
        findMaxLength1(new int[]{0,0,1,0,0,0,1,1});
    }
}
