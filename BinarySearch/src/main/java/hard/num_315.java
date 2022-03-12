package hard;

import java.util.ArrayList;
import java.util.List;

public class num_315 {
    //315. 计算右侧小于当前元素的个数
    /*
    * 给你一个整数数组 nums ，按要求返回一个新数组 counts 。
    * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
    * */
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[n];
        count[n-1] = 0 ;
        for (int i = 0; i < n - 1; i++) {
            int num = nums[i];
            int l = i + 1 , r = n - 1 ;
            //找到右侧第一个比nums[i]小的值
            while (l <= r){
                int mid = (l + r) >> 1 ;

            }
        }
        return ans ;
    }
}
