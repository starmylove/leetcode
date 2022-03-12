package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class num_42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0 ;
        for(int i = 0 ; i < height.length ; i ++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                ans += (i - left - 1 ) * (Math.min(height[left], height[i]) - height[top]);
            }
            stack.push(i);
        }
        return ans ;
    }
    public int trap1(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currWidth * currHeight;
            }
            stack.push(i);
        }
        return ans;
    }
}
