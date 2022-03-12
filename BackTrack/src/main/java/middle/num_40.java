package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_40 {
    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited ;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        traceBack(candidates,target,0,new ArrayList<Integer>());
        return ans;
    }
    private void traceBack(int[] candidates, int target, int index, ArrayList<Integer> path) {
        if(target == 0){
            ans.add((List<Integer>) path.clone());
            return;
        }
        if(index == candidates.length){
            return;
        }
        if(index > 0 && candidates[index] == candidates[index-1] && !visited[index-1]){
            traceBack(candidates,target,index+1,path);
            return;
        }
        if(target > 0 && index < candidates.length && candidates[index] <= target){
            path.add(candidates[index]);
            visited[index] = true;
            traceBack(candidates,target-candidates[index],index+1,path);
            path.remove(path.size()-1);
            visited[index] = false;
            traceBack(candidates,target,index+1,path);
        }
    }
    @Test
    public void test(){
        combinationSum2(new int[]{1,2,2,2,5},8);
    }
}
