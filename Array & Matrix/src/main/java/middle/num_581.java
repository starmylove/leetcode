package middle;

import org.junit.Test;

public class num_581 {
    //581. 最短无序连续子数组
    /*
    * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，
    * 那么整个数组都会变为升序排序。请你找出符合题意的 最短 子数组，并输出它的长度。
    * */
    public int findUnsortedSubarray(int[] nums) {
        int l , r , max , n = nums.length;
        int index = 0 ;
        while (index < n - 1 && nums[index] <=nums[index+1]){
            index++;
        }
        if(index == n - 1) {
            return 0;
        }
        l = index ;
        r = l + 1 ;
        max = nums[l];
        while (l > 0 && nums[l-1] > nums[r]){
            l--;
        }
        for (int i = r ; i < n ; i++) {
            if(i == n -1 ) {
                while (l > 0 && nums[l-1] > nums[i]){
                    l--;
                }
                if( nums[i] < max) {
                    r = n - 1 ;
                }
                break;
            }
            while (l > 0 && nums[l-1] > nums[i]){
                l--;
            }
            if(nums[i] < max ){
                r = i  ;
            }
            if(nums[i] > nums[i+1] || (nums[i] == nums[i+1] && r == i)){
                r = i + 1 ;
            }
            max = Math.max(max,nums[i]);
        }
        return r - l + 1 ;
    }
    @Test
    public void test(){
        System.out.println(findUnsortedSubarray(new int[]{1,3,5,4,2}));
    }
}













