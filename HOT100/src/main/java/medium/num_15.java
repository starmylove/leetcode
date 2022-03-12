package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int first = 0 ; first < nums.length - 2 ; first ++){
            if(nums[first] > 0 ){
                return ans ;
            }
            if(first > 0 && nums[first] == nums[first-1]){
                continue;
            }
            int target = -nums[first];
            int second = first + 1 , third = n - 1 ;
            while(second < third){
                if(nums[second] + nums[third] > target){
                    third -- ;
                }else if(nums[second] + nums[third] < target){
                    second ++ ;
                }else{
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first] );
                    list.add(nums[second] );
                    list.add(nums[third] );
                    ans.add(list);
                    while(second + 1 < third && nums[second] == nums[second+1]){
                        second ++ ;
                    }
                    while (third - 1 > second && nums[third] == nums[third-1]){
                        third -- ;
                    }
                    second ++ ;
                    third -- ;
                }
            }
        }
        return ans ;
    }
    @Test
    public void test(){
        threeSum(new int[]{0,0,0,0});
    }
}
