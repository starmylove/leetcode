package middle;

public class num_740 {
    //740. 删除并获得点数
    public int deleteAndEarn(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = 0 ;
        for(int i : nums) {
            if(length<i) {
                length = i;
            }
        }
        int[] numss = new int[length+1];
        for(int i : nums) {
            numss[i] = numss[i]+1;
        }
        int a = numss[1];
        int b = Math.max(a,2*numss[2]);
        int c = 0 ;
        for (int i = 3; i < numss.length; i++) {
            c = Math.max(b,nums[i]*i+a );
            a=b;
            b=c;
        }
        return c;
    }
}
