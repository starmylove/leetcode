package middle;

public class num_213 {
    //打家劫舍2
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[1],nums[0]);
        }
        if (nums.length == 3) {
            return Math.max(nums[2], Math.max(nums[1],nums[0]));
        }
        int a , b ,c =0;
        //第一间房子被偷
        a = nums[0];
        b = Math.max(nums[1],nums[0]);
        for (int i = 2; i < nums.length-1; i++) {
            c = Math.max(b,nums[i]+a );
            a=b;
            b=c;
        }
        int ans1 = c;
        //第一间房子不被偷
        a =  nums[1];
        b = Math.max(nums[1],nums[2]);
        for (int i = 3; i < nums.length; i++) {
            c = Math.max(b,nums[i]+a );
            a=b;
            b=c;
        }
        return ans1>c?ans1:c;
    }
}
