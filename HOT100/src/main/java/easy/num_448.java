package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i] - 1] != nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1){
                ans.add(i + 1) ;
            }
        }
        return ans ;
    }
    public void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp ;
    }
    @Test
    public void test(){
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
