package medium;

public class num_152 {
    public int maxProduct(int[] nums) {
        int max = nums[0] , min = nums[0] , ans = max;
        for (int i = 1; i < nums.length ; i++) {
            int maxF = max , minF= min ;
            max = Math.max(maxF,Math.max(maxF*nums[i],minF*nums[i]));
            min = Math.min(minF,Math.max(maxF*nums[i],minF*nums[i]));
            ans = Math.max(ans,max);
        }
        return ans;
    }
}
