package hard;

import org.junit.Test;

import java.util.*;

public class num_239 {
    //239. 滑动窗口最大值
    /*
    * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
    * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0]!=pair2[0]?pair2[0]-pair1[0]:pair2[1]-pair1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i],i});
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = queue.peek()[0];
        for (int i = k; i < nums.length; i++) {
            queue.offer(new int[]{nums[i],i});
            while (queue.peek()[1]<=i-k){
                queue.poll();
            }
            ans[i-k+1]=queue.peek()[0];
        }
        return ans;
    }
    public int[] maxSlidingWindow1(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[nums.length-k+1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst()<i-k+1){
                deque.removeFirst();
            }
            while (!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            ans[i-k+1] = nums[deque.getFirst()];
        }
        return ans;
    }
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; i++) {
            if(i%k==0){
                prefixMax[i]=nums[i];
            }else {
                prefixMax[i] = Math.max(prefixMax[i-1],nums[i] );
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            if(i==n-1||(i+1)%k==0){
                suffixMax[i] = nums[i];
            }else {
                suffixMax[i] = Math.max(suffixMax[i+1],nums[i]);
            }
        }
        int[] ans = new int[n-k+1];
        for (int i = 0; i <= n-k; i++) {
            ans[i] = Math.max(suffixMax[i],prefixMax[i+k-1] );
        }
        return ans;
    }
    //滑动窗口
    public int[] maxSlidingWindow4(int[] nums, int k){
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!queue.isEmpty() && queue.peekLast() <nums[i]){
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
        }
        int[] ans = new int[nums.length - k + 1] ;
        ans[0] = queue.peekFirst();
        for (int i = k; i < nums.length; i++) {
            int poll = nums[i-k];
            if(poll == queue.peekFirst()){
                queue.pollFirst();
            }
            while (!queue.isEmpty() && queue.peekLast() < nums[i]){
                queue.pollLast();
            }
            queue.offerLast(nums[i]);
            ans[i-k+1] = queue.peekFirst();
        }
        return ans;
    }







    @Test
    public void test(){
        int[] ints = maxSlidingWindow4(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}









