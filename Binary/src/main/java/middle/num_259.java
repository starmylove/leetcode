package middle;

import org.junit.Test;

import java.util.Arrays;

public class num_259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length - 2; i ++) {
            for(int j = i + 1; j < nums.length - 1; j ++) {
                int l = j + 1, r = nums.length - 1, num = target - nums[i] - nums[j];
                if(nums[l] >= num){
                    break;
                }
                int index = l - 1, temp = l;
                while(l <= r){
                    int mid = (r - l) / 2 + l;
                    if(nums[mid] >= num){
                        r = mid - 1;
                    }else{
                        index = mid;
                        l = mid + 1;
                    }
                }
                ans += index - temp + 1;
            }
        }
        return ans;
    }
    @Test
    public void test(){
        System.out.println(threeSumSmaller(new int[]{-2, 0, 1, 3, 2, 2, 2, 2}, 2));
    }
}
