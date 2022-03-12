package medium;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class num_347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<int[]> nodes = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i],freq.getOrDefault(nums[i],0) + 1 );
        }
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            if(nodes.size() < k){
                nodes.offer(new int[]{entry.getKey(), entry.getValue()});
            }else if(entry.getValue() > nodes.peek()[1]){
                nodes.poll();
                nodes.offer(new int[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] ans = new int[k];
        int index = 0 ;
        for(int[] node : nodes){
            ans[index ++] = node[0];
        }
        return ans;
    }
    @Test
    public void test(){
        topKFrequent(new int[]{1,1,1,2,2,3},2);
    }
}
