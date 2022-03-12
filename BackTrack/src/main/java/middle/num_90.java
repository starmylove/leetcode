package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_90 {

    int len ;
    boolean[] visited ;
    List<List<Integer>> res ;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        init(nums);
        dfs(nums,0,new ArrayList<Integer>());
        return res ;
    }

    private void dfs(int[] nums, int index,ArrayList<Integer> path) {
        if(index == len){
            res.add((List<Integer>) path.clone());
            return;
        }
        if(index == 0 || !(index > 0 && nums[index] == nums[index-1] && ! visited[index-1])){
            path.add(nums[index]);
            visited[index] = true ;
            dfs(nums,index+1,path);
            visited[index] = false;
            path.remove(path.size()-1);
        }
        dfs(nums,index+1,path);
    }

    private void init(int[] nums) {
        Arrays.sort(nums);
        len = nums.length;
        res = new ArrayList<>();
        visited = new boolean[len];
    }
}
