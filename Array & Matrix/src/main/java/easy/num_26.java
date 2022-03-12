package easy;

public class num_26 {
    //26. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums.length==1) {
            return nums.length;
        }
        int pos = 0 , i = 0;
        while (i<nums.length){
            int posNum = nums[i];
            while (i+1<nums.length&&nums[i+1]==nums[i]) {
                i++;
            }
            i++;
            nums[pos++] = posNum;
        }
        return pos;
    }
}
