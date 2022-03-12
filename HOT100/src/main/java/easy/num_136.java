package easy;

public class num_136 {
    public int singleNumber(int[] nums) {
        int sum = 0 ;
        for(int num : nums){
            sum ^= num;
        }
        return sum ;
    }
}
