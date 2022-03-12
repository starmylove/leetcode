package BFS.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_40 {
    //40. 组合总和 II
    /*
    * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    * candidates 中的每个数字在每个组合中只能使用一次。
    * 注意：解集不能包含重复的组合。
    * */
    List<List<Integer>> ans = new ArrayList<>();
    List<int[]> freq = new ArrayList<>();
    List<Integer> sequence = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //预处理每个数字出现的频率
        Arrays.sort(candidates);
        int cur = candidates[0], index = 0 ;
        freq.add(new int[]{cur,1});
        for (int i = 1; i < candidates.length; i++) {
            if(candidates[i] == cur){
                freq.get(index)[1] += 1;
            }else {
                index++;
                cur = candidates[i];
                freq.add(new int[]{cur,1});
            }
        }
        dfs(0,target);
        return ans;
    }
    private void dfs(int index, int res) {
        if(res == 0){
            ans.add(new ArrayList<>(sequence));
        }
        if(index == freq.size() || freq.get(index)[0] > res){
            return;
        }
        dfs(index+1,res);
        int most = Math.min(res/freq.get(index)[0],freq.get(index)[1]);
        for (int i = 1; i <= most; i++) {
            sequence.add(freq.get(index)[0]);
            dfs(index+1,res - i * freq.get(index)[0]);
        }
        for (int i = 0; i < most; i++) {
            sequence.remove(sequence.size()-1);
        }
    }
}














