package medium;

public class num_55 {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        int index = 0 ;
        while (index < nums.length && !(index == max && nums[index] == 0)){
            max = Math.max(max,nums[index]+index);
            if(max >= nums.length - 1){
                return true;
            }
            index ++ ;
        }
        return false ;
    }
    public boolean canJump1(int[] nums) {
        int max = 0 ;
        for (int i = 0; i < nums.length; i++) {
            if(i <= max){
                max = Math.max(max,i+nums[i]);
                if(max >= nums.length - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
