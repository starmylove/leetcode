package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class num_169 {
    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
    //你可以假设数组是非空的，并且给定的数组总是存在多数元素

    //Boyer-Moore 算法(摩尔投票法)
    public int majorityElement(int[] nums) {
        int candidate = 0 , count = 0 ;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if(count == 0) {
                candidate = nums[i];
            }
            if(candidate == nums[i]) {
                count ++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    //哈希表法
    public int majorityElement2(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(!(map.containsKey(num))) {
                map.put(num,1);
            } else {
                map.put(num,map.get(num)+1);
            }
        }
        Set<Map.Entry<Integer,Integer>> entrys = map.entrySet();
        Map.Entry<Integer,Integer> curentry = null;
        for(Map.Entry<Integer,Integer> entry : entrys) {
            if(curentry == null || entry.getValue()>curentry.getValue()) {
                curentry = entry;
            }
        }
        return curentry.getKey();
    }

}













