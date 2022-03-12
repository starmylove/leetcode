package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class num_46 {
    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */
    boolean[] visited ;
    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        visited = new boolean[length];
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            dfs(i,path,1,nums);
            visited[i]=false;
            path.remove(path.size()-1);
        }
        return ans;
    }

    private void dfs(int i, List<Integer> path , int depth,int[] nums) {
        visited[i] = true ;
        path.add(nums[i]);
        if(depth==nums.length){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j : path){
                list.add(j);
            }
            ans.add(list);
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if(!visited[j]){
                dfs(j,path,depth+1,nums);
                path.remove(path.size()-1);
                visited[j]=false;
            }
        }
    }
    @Test
    public void test(){
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute.toString());
    }
}
