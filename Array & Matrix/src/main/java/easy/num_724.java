package easy;

public class num_724 {
    public int pivotIndex(int[] nums) {
        int sum = 0 ;
        for(int num : nums) {
            sum += num ;
        }
        int leftSum = 0 , n = nums.length;
        for (int i = 0; i < n; i++) {
            if(leftSum == sum - leftSum - nums[i]) {
                return i ;
            }
            leftSum += nums[i];
        }
        return -1 ;
    }
}
