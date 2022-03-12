package medium;

public class num_31 {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1 ;
        while(index > 0 && nums[index] <= nums[index - 1]){
            index -- ;
        }
        if(index == 0){
            for(int i = 0 ; i < nums.length / 2 ; i ++){
                swap(nums , i , nums.length - 1 - i);
            }
        }else{
            index -- ;
            for (int i = nums.length - 1; i > index ; i--) {
                if(nums[i] > nums[index]){
                    swap(nums,index,i);
                    break;
                }
            }
            for(int i = index + 1 , j = nums.length - 1; i < j ; i ++ , j --){
                swap(nums , i , j);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
}
