package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_47_bitset {
    //99% 83%
    List<List<Integer>> ans = new ArrayList<>();
    private int visit , mask = 0 ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        mask = 1 << (length - 1);
        mask |= (mask >> 1);
        mask |= (mask >> 2);
        mask |= (mask >> 4);
        mask |= (mask >> 8);
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list);
        return ans;
    }
    public void dfs(int[] nums , int index , List<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        int unvisited = (~visit) & mask ;
        while (unvisited!=0){
            int digit = unvisited & (-unvisited) ;
            int d = Integer.bitCount(digit-1);
            while (d>0 && nums[d] == nums[d-1] && (visit & (1 << (d-1)))==0){
                unvisited ^=digit;
                digit = unvisited & (-unvisited);
                d = Integer.bitCount(digit-1);
                if(d>= nums.length) {
                    return;
                }
            }
//            if(d>0 && nums[d] == nums[d-1] && (visit & (1 << (d-1)))==0)continue;
            visit ^= (1 << d);
            list.add(nums[d]);
            dfs(nums, index + 1, list);
            visit ^= (1 << d);
            list.remove(list.size() - 1);
            unvisited &= (unvisited-1) ;
        }
    }
    @Test
    public void test(){
        List<List<Integer>> lists = permuteUnique(new int[]{1,1, 2,8,54,3,6});
        System.out.println(lists.toString());
    }
}
