package hard;

import java.util.Stack;

public class num_84 {
    //84. 柱状图中最大的矩形
    /*
    * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。
    * 每个柱子彼此相邻，且宽度为 1 。
    * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
    * */

    /*
    * 在一维数组中对每一个数找到第一个比自己小的元素。
    * 这类“在一维数组中找第一个满足某种条件的数”的场景就是典型的单调栈应用场景。
    *
    * 单调栈学习建议以及练习：「力扣」第 42、739、496、316、901、402、581 题。
    *
    *
    * */

    //以下是看了官方题解的思路之后写的，速度比官方代码快很多
    //但是仍然很慢，对比了最快代码，发现是使用了Stack的原因，使用自定义的栈就会快很多
    //JAVA自带的Stack巨慢，建议自定义栈使用
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0 ;
        for (int i = 0; i < heights.length; i++) {
            int heightI = heights[i];
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && heights[stack.peek()]>heightI){
                int popHeight = heights[stack.pop()];
                ans = Math.max(ans , popHeight * (i - (stack.isEmpty()?-1:stack.peek())-1));
            }
            stack.push(i) ;
        }
        int end = stack.peek() ;
        while (!stack.isEmpty()){
            int popHeight = heights[stack.pop()];
            ans = Math.max(ans , popHeight * (end - (stack.isEmpty()?-1:stack.peek())));
        }
        return ans;
    }

    //最快解法
    public int largestRectangleArea1(int[] arr) {
        int ans = 0;
        int[] stack = new int[arr.length];
        int index = -1;
        for (int i = 0; i < arr.length; i++) { // 当遍历到i位置的数，arr[i]
            while (index != -1 && arr[stack[index]] > arr[i]) {
                int j = stack[index--];
                int leftLessIndex = index==-1 ? -1 : stack[index];
                ans = Math.max(ans,arr[j] * (i-leftLessIndex-1));
            }
            stack[++index] = i;
        }
        while (index != -1) {
            int j = stack[index--];
            int leftLessIndex = index==-1 ? -1 : stack[index];
            ans = Math.max(ans,arr[j] * (arr.length-leftLessIndex-1));
        }
        return ans;
    }

    //复现最快解法
    //100% 78%
    public int largestRectangleArea2(int[] heights) {
        int ans = 0 ;
        int[] stack = new int[heights.length];
        int index = -1 ;
        for (int i = 0; i < heights.length; i++) {
            while (index != -1  && heights[stack[index]]>heights[i]){
                int popHeight = heights[stack[index--]];
                ans = Math.max(ans , popHeight * (i - (index==-1?-1:stack[index])-1));
            }
            stack[++index ] = i ;
        }
        int end = stack[index] ;
        while (index!=-1){
            int popHeight = heights[stack[index--]];
            ans = Math.max(ans , popHeight * (end - ( index == -1?-1:stack[index] )));
        }
        return ans;
    }
}
