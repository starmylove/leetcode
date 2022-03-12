package middle;

import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

public class num_31 {
    //31. 下一个排列
    /*
    * 实现获取 下一个排列 的函数，
    * 算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    * 必须 原地 修改，只允许使用额外常数空间。
    * */
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int i = length - 1 ;
        while (i > 0 && nums[i] <= nums[i-1]) {
            i--;
        }
        if(i == 0){
            //将nums数组升序排序
            for (int j = 0; j < length/2; j++) {
                swap(nums,j,length-1-j);
            }
            return;
        }
        int j = length - 1 ;
        while (nums[j] <= nums[i - 1]) {
            j--;
        }
        swap(nums,j,i-1);
        for (int left = i , right = length - 1; left <right ; left++,right--) {
            swap(nums,left,right);
        }
    }

    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    @Test
    public void test(){
//        int[] nums = new int[]{1,2,3,5,2,1,2,1,1,1};
        int[] nums = new int[]{1,2,3};
        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
