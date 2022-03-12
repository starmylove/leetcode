package easy;

public class num_169 {
    public int majorityElement(int[] nums) {
        int cur = 0, cnt = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if(cnt == 0){
                cur = nums[i] ;
                cnt = 1 ;
            }else if(cur == nums[i]){
                cnt ++ ;
            }else {
                cnt -- ;
            }
        }
        return cur ;
    }
}
