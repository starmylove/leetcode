package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_47_bitset_exec {
    List<List<Integer>> ans = new ArrayList<>();
    int visited , mask = 1;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        mask <<= (n - 1) ;
        mask |= mask >> 1 ;
        mask |= mask >> 2 ;
        mask |= mask >> 4 ;
        backtrick(nums,0,new ArrayList<>());
        return ans;
    }

    private void backtrick(int[] nums, int index, ArrayList<Integer> list) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //依次将未访问过的数字填入index位置（要求不重复）
        int unvisited = (~visited) & mask ;
        while (unvisited!=0){
            int minUnvisited = unvisited & (-unvisited) ;
            int minUnvisitedIndex = Integer.bitCount(minUnvisited-1);
            while (minUnvisitedIndex > 0 && nums[minUnvisitedIndex] == nums[minUnvisitedIndex-1] && (visited & (1 << (minUnvisitedIndex-1)))==0){
                unvisited ^= minUnvisited ;
                minUnvisited = unvisited & (-unvisited) ;
                minUnvisitedIndex = Integer.bitCount(minUnvisited-1);
                if(minUnvisitedIndex >= nums.length) {
                    return;
                }
            }
            visited ^= minUnvisited;
            list.add(nums[minUnvisitedIndex] );
            backtrick(nums,index+1,list);
            visited ^= minUnvisited;
            list.remove(list.size()-1 );
            unvisited &= (unvisited - 1);
        }
    }
    @Test
    public void test(){
        List<List<Integer>> lists = permuteUnique(new int[]{1,1, 2,8,54,3,6});
        System.out.println(lists.toString());
    }
}











