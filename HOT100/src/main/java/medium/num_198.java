package medium;

public class num_198 {
    public int rob(int[] nums) {
        int steal = nums[0], noSteal = 0 ;
        for (int i = 1; i < nums.length; i++) {
            int temp = noSteal ;
            noSteal = Math.max(steal,noSteal);
            steal = nums[i] + temp ;
        }
        return Math.max(steal,noSteal);
    }
}
