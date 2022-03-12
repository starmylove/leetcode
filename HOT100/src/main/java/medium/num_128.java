package medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class num_128 {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                continue;
            }
            if(!map.containsKey(num-1) && !map.containsKey(num + 1)){
                map.put(num,map.getOrDefault(num,0)+1);
            }else if(!map.containsKey(num + 1)){
                map.put(num,map.get(num-1)+1);
            }else if(map.containsKey(num - 1) && map.containsKey(num + 1)){
                map.put(num,map.get(num-1)+1);
                num ++ ;
                while(map.containsKey(num)){
                    map.put(num,map.get(num-1)+1);
                    num ++ ;
                }
            }else{
                map.put(num++,1);
                while(map.containsKey(num)){
                    map.put(num,map.get(num-1)+1);
                    num ++ ;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i : map.values()){
            max = Math.max(max,i);
        }
        return max;
    }
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0 ;
        for(int num : set){
            if(set.contains(num - 1)){
                continue;
            }else {
                int len = 0 ;
                while (set.contains(num++)){
                    len ++ ;
                }
                max = Math.max(max,len);
            }
        }
        return max;
    }
    @Test
    public void test(){
        longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1});
    }
}
