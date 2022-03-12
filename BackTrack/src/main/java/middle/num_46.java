package middle;

import java.util.ArrayList;
import java.util.List;

public class num_46 {
    boolean[] visited ;
    int len = 0 ;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        visited = new boolean[len];
        traceBack(nums,new ArrayList<Integer>());
        return ans ;
    }

    private void traceBack(int[] nums,ArrayList<Integer> path) {
        if(path.size() == len){
            ans.add((List<Integer>) path.clone());
            return;
        }
        for(int i = 0 ; i < len ; i ++){
            if(!visited[i]){
                visited[i] = true ;
                path.add(nums[i]);
                traceBack(nums,path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }
}
