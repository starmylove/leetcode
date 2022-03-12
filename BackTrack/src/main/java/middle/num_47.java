package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_47 {
    boolean[] visited ;
    int len = 0 ;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        len = nums.length;
        visited = new boolean[len];
        Arrays.sort(nums);
        traceBack(nums,0,new ArrayList<Integer>());
        return ans ;
    }

    private void traceBack(int[] nums, int index, ArrayList<Integer> path) {
        if(path.size() == len){
            ans.add((List<Integer>) path.clone());
            return;
        }
        for(int i = 0 ; i < len ; i ++){
            if(!visited[i]){
                if(i > 0 && !visited[i-1] && nums[i] == nums[i-1]){
                    continue;
                }
                visited[i] = true ;
                path.add(nums[i]);
                traceBack(nums,index+1,path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
