package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_15_2 {
    //三数之和
    /*
    * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
    * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
    * 注意：答案中不可以包含重复的三元组。
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int left = 0; left < n - 2; left++) {
            if(left > 0 && nums[left] == nums[left-1]) {
                continue;
            }
            int mid = left+1 , right = n - 1 , target = -nums[left];
            for (  ; mid < right; mid++) {
                if(mid > left+1 && nums[mid] == nums[mid-1]) {
                    continue;
                }
                while (mid < right && nums[mid] + nums[right] > target) {
                    right--;
                }
                if (mid == right) {
                    break;
                }
                if(nums[mid] + nums[right] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[left]);
                    list.add(nums[mid]);
                    list.add(nums[right]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}















