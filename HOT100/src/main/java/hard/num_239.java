package hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class num_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.getLast() < nums[i]){
                queue.removeLast();
            }
            queue.offer(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1];
        int index = 0 ;
        ans[index++] = queue.peek();
        for (int i = 1; i + k - 1 < nums.length; i++) {
            if(queue.peek() == nums[i - 1]){
                queue.poll();
            }
            while (!queue.isEmpty() && queue.getLast() < nums[i + k - 1]){
                queue.removeLast();
            }
            queue.offer(nums[i + k - 1]);
            ans[index++] = queue.peek();
        }
        return ans;
    }
}
