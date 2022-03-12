package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_47 {
    //47. 全排列 II
    /*
    * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
    * */
    List<List<Integer>> ans = new ArrayList<>();
    private int visited = 0 , mask ;
    private boolean[] visit ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        visit = new boolean[length];
        mask = 1 << (length - 1);
        mask |= (mask >> 1);
        mask |= (mask >> 2);
        mask |= (mask >> 4);
        mask |= (mask >> 8);
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list);
        return ans;
    }
    public void dfs(int[] nums , int index , List<Integer> list){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length ; i++) {
            if(visit[i] || (i>0 && nums[i] == nums[i-1] && !visit[i-1])) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i] );
            dfs(nums,index+1,list);
            visit[i] = false;
            list.remove(list.size()-1);
        }
//        if(index > 0 && nums[index] == nums[index-1] && (visited<<index-1)!=0)
//            return;
//        visited ^= (1 << index);//index=0时 visited与000001异或
//        list.add(nums[index]);
//        int unvisited = (~visited) & mask ;
//        while (unvisited!=0){
//
//        }
//        visited ^= (1 << index);
//        list.remove(list.size()-1);
    }

    @Test
    public void test(){
        List<List<Integer>> lists = permuteUnique(new int[]{1, 1, 2});
        System.out.println(lists.toString());
    }
}
