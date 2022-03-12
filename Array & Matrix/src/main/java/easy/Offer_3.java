package easy;

import java.util.HashSet;
import java.util.Set;
/*
* 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
* 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
* 请找出数组中任意一个重复的数字。
*/
public class Offer_3 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        int ans = findRepeatNumber1(nums);
        System.out.println(ans);
    }

    //哈希集合法，空间复杂度为n，时间复杂度为n
    public static int findRepeatNumber(int[] nums) {
        Set set = new HashSet();
        int ans = 0;
        for(int num:nums){
            if(!set.add((int)num)){
                ans=num;
                break;
            }
        }
        return ans;
    }
    //空间复杂度是1，时间复杂度是n的方法
    public static int findRepeatNumber1(int[] nums){
        //原理：如果将这个数组排序后，重复的数字对应下标的位置会有多个数字，
        // 未出现的数字对应下标的位置没有数字
        int ans = 0 ;
        for(int i = 0 ; i <nums.length ; i++){
            if(nums[i]!=i){
                if(nums[nums[i]]==nums[i]){
                    ans =nums[i];
                    return ans;
                }else{
                    swap(nums,i,nums[i]);
                    i--;
                }
            }
        }
        return ans;
    }
    public static void swap(int[] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
}
