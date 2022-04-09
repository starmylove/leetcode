package hard;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class num_327 {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
        }
        Set<Long> allNums = new TreeSet<>();
        for (long num : preSum) {
            allNums.add(num);
            allNums.add(num - upper);
            allNums.add(num - lower);
        }
        Map<Long, Integer> map = new HashMap<>();
        int index = 0;
        for(Long num : allNums) {
            map.put(num, index ++);
        }
        int sum = 0;
        c = new int[map.size() + 1];
        for(long num : preSum){
            int left = map.get(num - upper), right = map.get(num - lower);
            sum += query(right) - query(left - 1);
            update(map.get(num));
        }
        return sum;
    }
    int[] c;
    public int query(int index) {
        int sum = 0;
        while(index > 0) {
            sum += c[index];
            index -= lowbit(index);
        }
        return sum;
    }
    public void update(int index) {
        while(index < c.length) {
            c[index] ++;
            index += lowbit(index);
        }
    }

    public int lowbit(int x) {
        return x & -x;
    }
    @Test
    public void test(){
        int i = countRangeSum(new int[]{-2, 5, -1}, -2, 2);
        System.out.println(i);

    }
}
