package medium;

import java.util.ArrayList;
import java.util.List;

public class num_46 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited ;
    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length] ;
        dfs(nums,0,new ArrayList<>());
        return ans ;
    }

    private void dfs(int[] nums, int index, ArrayList<Object> path) {
        //跳出条件
        if(index == nums.length){
            ans.add((List<Integer>) path.clone());
        }
        //考虑第index个位置可以放谁
        for(int i = 0 ; i  < nums.length ; i ++){
            if(!visited[i]){
                path.add(nums[i]);
                visited[i] = true ;
                dfs(nums,index+1,path);
                path.remove(path.size()-1);
                visited[i] = false ;
            }
        }
    }
}
