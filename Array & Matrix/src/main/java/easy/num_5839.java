package easy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class num_5839 {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        } );
        for(int pile : piles){
            queue.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            int poll = queue.poll();
            poll -= poll/2;
            queue.offer(poll);
        }
        int ans = 0 ;
        while (!queue.isEmpty()) {
            ans += queue.poll();
        }
        return ans;
    }
}
