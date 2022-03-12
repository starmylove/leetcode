package medium;

import java.util.PriorityQueue;

public class num_215 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            if(queue.size() < k){
                queue.offer(nums[i]);
            }else if(nums[i] > queue.peek()){
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}
