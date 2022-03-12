package middle;

import org.junit.Test ;
import java.util.*;

public class num_40 {
    List<int[]> freq = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int cur = candidates[0] , index = 0 ;
        freq.add(new int[]{cur,1});
        for (int i = 1; i < candidates.length; i++) {
            if(candidates[i]==cur){
                freq.get(index)[1] += 1 ;
            }else {
                index++;
                cur = candidates[i];
                freq.add(new int[]{cur,1});
            }
        }
        dfs(0,target);
        return ans ;
    }

    private void dfs(int index, int res) {
        if(res == 0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if(index == freq.size() || res < freq.get(index)[0]) {
            return;
        }
        dfs(index+1,res);
        int most = Math.min(res/freq.get(index)[0],freq.get(index)[1]);
        for (int i = 1; i <= most; i++) {
            path.add(freq.get(index)[0]);
            dfs(index+1,res - i*freq.get(index)[0]);
        }
        for (int i = 0; i < most; i++) {
            path.remove(path.size()-1);
        }
    }
    @Test
    public void test(){
        combinationSum2(new int[]{1,1},1);
    }
}










