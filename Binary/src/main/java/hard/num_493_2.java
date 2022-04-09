package hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class num_493_2 {
    int[] tree;
    public int reversePairs(int[] nums) {
        TreeSet<Long> allNums = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++) {
            allNums.add((long)nums[i]);
            allNums.add(2 * (long)nums[i]);
        }
        Map<Long, Integer> map = new HashMap<>();
        int index = 1;
        for (Long num : allNums) {
            map.put(num, index ++);
        }
        tree = new int[map.size() + 2];
        int ans = 0;
        for(int i = nums.length - 1; i >= 0; i --) {
            ans += query(map.get((long)nums[i]) - 1);
            update(map.get(nums[i] * 2L));
        }
        return ans;
    }
    public int lowbit(int x){
        return x & -x;
    }
    public int query(int index){
        int sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= lowbit(index);
        }
        return sum;
    }
    public void update(int index){
        while (index < tree.length){
            tree[index] ++;
            index += lowbit(index);
        }
    }

    @Test
    public void test(){
        System.out.println(reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}
