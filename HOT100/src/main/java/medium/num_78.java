package medium;

import java.util.ArrayList;
import java.util.List;

public class num_78 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited ;
    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums,new ArrayList<Integer>(),0);
        return ans ;
    }

    private void dfs(int[] nums, ArrayList<Integer> path, int index) {
        if(index == nums.length){
            ans.add((List<Integer>) path.clone());
            return;
        }
        path.add(nums[index]);
        visited[index] = true ;
        dfs(nums,path,index+1);
        visited[index] = false ;
        path.remove(path.size()-1);
        dfs(nums,path,index+1);
    }
}
