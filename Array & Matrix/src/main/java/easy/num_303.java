package easy;

public class num_303 {
    int[] preSum ;
    public num_303(int[] nums) {
        int n = nums.length;
        preSum = new int[n+1];
        preSum[0] = nums[0];
        for (int i = 1; i <= n; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
        }
    }
    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left ] ;
    }
}
