package middle;

import org.junit.Test;

public class num_80 {
    //80. 删除有序数组中的重复项 II
    /*
    * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，
    * 返回删除后数组的新长度。不要使用额外的数组空间，
    * 你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
    * */
    public int removeDuplicates(int[] nums) {
        int n = nums.length , curNum = nums[0], curIndex = 1 , curLen = 1;
        for (int i = 1; i < n; i++) {
            if(nums[i] == curNum){
                curLen++;
                if(curLen <= 2) {
                    nums[curIndex++] = curNum ;
                }
            }else {
                curNum = nums[i];
                curLen = 1 ;
                nums[curIndex++] = curNum ;
            }
        }
        return curIndex ;
    }
    @Test
    public void test(){
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
