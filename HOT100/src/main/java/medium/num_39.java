package medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_39 {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(target,candidates,new ArrayList<>(),0);
        return ans ;
    }

    private void dfs(int target,int[] candidates, ArrayList<Integer> path, int index) {
        if(target == 0){
            ans.add((List<Integer>) path.clone());
            return;
        }
        if(index == candidates.length || candidates[index] > target){
            return;
        }
        path.add(candidates[index]);
        dfs(target - candidates[index],candidates,path,index);
        path.remove(path.size()-1);
        dfs(target,candidates,path,index+1);
    }
    @Test
    public void test(){
        combinationSum(new int[]{2,3,6,7},7);
    }
}
