package easy;

public class num_27 {
    //27 移除元素
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length==1) {
            return nums[0]==val?0:1;
        }
        int left = 0 , right = nums.length-1;
        while(left < right){
            while(left<nums.length&&nums[left]!=val) {
                left++;
            }
            while (right>=0&&nums[right]==val) {
                right--;
            }
            if(left<right) {
                swap(nums,left,right);
            }
        }
        return left;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
