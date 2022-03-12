package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_78_subset {
    public List<List<Integer>> subsets(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(nums,0,len,temp,ans);
        return ans;
    }
    public void dfs(int[] nums , int k ,  int len , List<Integer> tmp ,List<List<Integer>> ans){
        if(k==len-1){
            ans.add(new ArrayList<>(tmp));
            tmp.add(nums[k]);
            ans.add(new ArrayList<>(tmp));
            tmp.remove((Object)nums[k]);
            return;
        }
        else{
            dfs(nums,k+1,len,tmp,ans);
            tmp.add(nums[k]);
            dfs(nums,k+1,len,tmp,ans);
        }
        tmp.remove((Object)nums[k]);
    }
    public void dfs2(int[] nums , int k ,  int len , List<Integer> tmp ,List<List<Integer>> ans){
        if(k==len){
            ans.add(new ArrayList<>(tmp));
            return;
        }
        dfs(nums,k+1,len,tmp,ans);
        tmp.add(nums[k]);
        dfs(nums,k+1,len,tmp,ans);
        tmp.remove((Object)nums[k]);
    }
    @Test
    public void test(){
        System.out.println(subsets(new int[]{}));
    }

}
