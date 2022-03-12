package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class num_739 {
    public int[] dailyTemperatures1(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if(stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]){
                stack.push(i);
            }{
                while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                    ans[stack.peek()] = i - stack.pop() ;
                }
                stack.push(i);
            }
        }
        return ans;
    }
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        ans[temperatures.length - 1] = 0 ;
        for (int i = temperatures.length - 2 ; i >= 0 ; i--) {
            for (int j = i + 1 ; j < temperatures.length; j += ans[j]) {
                if(temperatures[i] < temperatures[j]){
                    ans[i] = j - i ;
                    break;
                }else if(ans[j] == 0){
                    break;
                }
            }
        }
        return ans ;
    }
}
