package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class num_39 {
    /*
    * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，
    * 找出 candidates 中所有可以使数字和为目标数 target 的唯一组合。
    * candidates 中的数字可以无限制重复被选取。
    * 如果至少一个所选数字数量不同，则两种组合是唯一的。
    * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
    * */
    private List<List<Integer>> ans = new ArrayList<List<Integer>>();
    private int n ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序去重
        Arrays.sort(candidates);
        int left = 0 , right = candidates.length-1, mid = 0;
        while (left<=right){
            mid = (left + right)/2;
            if(target==candidates[mid]) {
                break;
            }
            if(target>candidates[mid]) {
                left = mid + 1 ;
            } else {
                right = mid-1;
            }
        }
        int n = mid ;
        if(n<candidates.length&&candidates[n]==target){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(target);
            ans.add(list);
            n--;
        }
        this.n=n;
        List<Integer> path = new ArrayList<>();
        for (int i = 0;i<candidates.length && candidates[i]<=target/2; i++) {
            path.clear();
            path.add(candidates[i]);
            dfs(target-candidates[i],i,path,candidates);
        }
        return ans;
    }

    public void dfs(int target,int start,List<Integer> path,int[] candidates) {
        if(target<0) {
            return;
        }
        if(target==0){
            List<Integer> list = new ArrayList<Integer>();
            for(int i : path) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        for (int i = start; i <= n ; i++) {
            path.add(candidates[i]);
            dfs(target-candidates[i],i,path,candidates);
            path.remove(path.size()-1);
        }
    }
    @Test
    public void test(){
        int[] candidates = new int[]{2,3,5};
        List<List<Integer>> lists = combinationSum(candidates, 8);
        System.out.println(lists.toString());
    }
}
