package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_39 {
    List<List<Integer>> res = new ArrayList<>();
    int n ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        int l = 0 , r = candidates.length - 1 , mid = 0 ;
        while(l <= r){
            mid = ( l + r) / 2 ;
            if(candidates[mid] == target){
                break;
            }else if(candidates[mid] > target){
                r = mid - 1 ;
            }else{
                l = mid + 1 ;
            }
        }
        n = mid ;
        dfs(candidates,target,new ArrayList<Integer>(),0);
        return res ;
    }

    private void dfs(int[] candidates, int target, ArrayList<Integer> path, int start) {
        if(target == 0 ){
            res.add((List<Integer>) path.clone());
            return;
        }
        if(target < 0 || start > n|| candidates[start] > target ){
            return;
        }
        path.add(candidates[start]);
        dfs(candidates,target-candidates[start],path,start);
        path.remove(path.size()-1);
        dfs(candidates,target,path,start+1);
    }
    @Test
    public void test(){
        combinationSum(new int[]{7,3,9,6},6);
    }
}
