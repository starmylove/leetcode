package hard;

import java.util.*;

public class num_315_2 {
    //315. 计算右侧小于当前元素的个数
    /*
     * 给你`一个整数数组 nums ，按要求返回一个新数组 counts 。
     * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     * */
    int[] a , c ;
    public List<Integer> countSmaller(int[] nums) {
        discretization(nums);
        init(a.length+5);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0 ; --i) {
            int id = getId(nums[i]);
            res.add(query(id-1));
            update(id);
        }
        Collections.reverse(res); ;
        return res ;
    }

    private void update(int id) {
        while (id < c.length){
            c[id] += 1 ;
            id += lowbit(id) ;
        }
    }

    private int query(int i) {
        int sum = 0 ;
        while (i != 0){
            sum += c[i];
            i -= lowbit(i);
        }
        return sum ;
    }

    private int lowbit(int i) {
        return i & -i ;
    }

    private int getId(int num) {
        return Arrays.binarySearch(a,num)+ 1;
    }

    private void init(int length) {
        c = new int[length];
    }

    private void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        a = new int[set.size()];
        int index = 0 ;
        for(int num : set){
            a[index++] = num;
        }
        Arrays.sort(a);
    }
}
