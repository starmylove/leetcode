package easy;

public class Offer_21 {
    //剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        if(nums.length<2) {
            return nums;
        }
        int left = 0 , right =nums.length-1;
        while (left<right){
            while (left<nums.length&&(nums[left]&1)!=0) {
                left++;
            }
            while (right>=0&&(nums[right]&1)!=1) {
                right--;
            }
            if(left<right) {
                swap(nums,left,right);
            }
            left++;
            right--;
        }
        return nums;
    }
    public void swap(int[] nums , int left , int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
