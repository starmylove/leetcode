package middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class num_47_boolean {
    List<List<Integer>> ans = new ArrayList<>();
    private boolean[] visit ;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        visit = new boolean[length];
        List<Integer> list = new ArrayList<>();
        dfs(nums,0,list);
        return ans;
    }
    public void dfs(int[] nums , int index , List<Integer> list) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            dfs(nums, index + 1, list);
            visit[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
