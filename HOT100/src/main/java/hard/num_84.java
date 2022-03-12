package hard;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class num_84 {
    public int largestRectangleArea(int[] heights) {
        //找到左右两个第一个比自己小的
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length ;
        int[] left = new int[len] , right = new int[len] ;
        left[0] = -1 ;
        right[len - 1] = len ;
        //寻找每个元素左侧第一个比自己小的
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1 ;
            }else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        stack.push(len-1);
        for (int i = len - 2; i  >= 0; i --) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = len ;
            }else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        int ans = 0 ;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,(right[i] - left[i] - 1) * heights[i]);
        }
        return ans ;
    }
    //优化
    public int largestRectangleArea1(int[] heights) {
        //找到左右两个第一个比自己小的
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heights.length ;
        int[] left = new int[len] , right = new int[len] ;
        left[0] = -1 ;
        right[len - 1] = len ;
        //寻找每个元素左侧第一个比自己小的
        stack.push(0);
        for (int i = 1; i < len; i++) {
            while(!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                right[stack.pop()] = i ;
            }
            if(stack.isEmpty()){
                left[i] = -1 ;
            }else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            right[stack.pop()] = len ;
        }
        int ans = 0 ;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans,(right[i] - left[i] - 1) * heights[i]);
        }
        return ans ;
    }
    @Test
    public void test(){
        largestRectangleArea(new int[]{2,1,5,6,2,2,2,3});
    }
}
