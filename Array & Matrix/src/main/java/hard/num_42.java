package hard;


import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

import static java.lang.Math.min;

public class num_42 {
    public int trap(int[] height) {
        //单调栈
        /*
        * 维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height\textit{height}height 中的元素递减。
从左到右遍历数组，遍历到下标 iii 时，如果栈内至少有两个元素，记栈顶元素为 top\textit{top}top，top\textit{top}top 的下面一个元素是 left\textit{left}left，则一定有 height[left]≥height[top]\textit{height}[\textit{left}] \ge \textit{height}[\textit{top}]height[left]≥height[top]。如果 height[i]>height[top]\textit{height}[i]>\textit{height}[\textit{top}]height[i]>height[top]，则得到一个可以接雨水的区域，该区域的宽度是 i−left−1i-\textit{left}-1i−left−1，高度是 min⁡(height[left],height[i])−height[top]\min(\textit{height}[\textit{left}],\textit{height}[i])-\textit{height}[\textit{top}]min(height[left],height[i])−height[top]，根据宽度和高度即可计算得到该区域能接的雨水量。
为了得到 left\textit{left}left，需要将 top\textit{top}top 出栈。在对 top\textit{top}top 计算能接的雨水量之后，left\textit{left}left 变成新的 top\textit{top}top，重复上述操作，直到栈变为空，或者栈顶下标对应的 height\textit{height}height 中的元素大于或等于 height[i]\textit{height}[i]height[i]。
在对下标 iii 处计算能接的雨水量之后，将 iii 入栈，继续遍历后面的下标，计算能接的雨水量。遍历结束之后即可得到能接的雨水总量。
        * */
        int ans = 0 ;
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()&& height[i]>height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int curWidth = i-left-1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                ans += currHeight*curWidth;
            }
            stack.push(i);
        }
        return ans;
    }
//    public int trap(int[] height) {
//        //动态规划
//        //思路：
//        /*
//        * 对于每个格子，他能存放的水的高度，取决于min(该格子左侧所有格子最大值，该格子右侧所有格子最大值)
//        * 从最组左往右计算每个格子左侧所有格子高度最大值，最左边格子处填该格子高度即可
//        * 从最右侧往左计算每个格子右侧所有格子高度最大值，最右边格子处填该格子高度即可
//        *
//        * 时间1ms 击败99.99%
//        * 空间只有58%
//        *
//        * */
//        if(height.length==0)
//            return 0 ;
//        int[] dpLeft = new int[height.length];
//        int[] dpRight = new int[height.length];
//        dpLeft[0] = height[0];
//        dpRight[height.length-1] = height[height.length-1];
//        for (int i = 1; i < dpLeft.length; i++)
//            dpLeft[i] = Math.max(height[i],dpLeft[i-1]);
//        for(int i = dpRight.length-1 ; i>=0 ; i--)
//            dpRight[i] = Math.max(height[i],dpRight[i-1]);
//        int ans = 0 ;
//        for (int i = 0; i < height.length; i++)
//            ans += Math.min(dpLeft[i],dpRight[i])-height[i];
//        return  ans;
//    }
    //以下方法只能击败28%
//    public int trap(int[] height) {
//        int left = 0 , right ,  ans = 0 ;
//        while(left!=height.length&&left!=height.length-1){
//            //先找右端，一直往右走，走的过程中维护一个最大值。如果遇到比height[left]大的数，就让这个下标当右端，如果已经走到数组最右端依然没有比height[left]
//            //大的数，那就让中间最大值当右端
//
//            right = left+1;
//            int max_after_left = height[right] , max_index = right;
//            while(right<height.length&&height[left]>=height[right]){
//                if(height[right]>=max_after_left){
//                    max_index = right;
//                    max_after_left = height[right];
//                }
//                right++;
//            }
//            if(right==height.length){
//                ans+=square(height,left,max_index);
//                left = max_index;
//            }else{
//                ans+=square(height,left,right);
//                left = right;
//            }
//        }
//        return ans;
//    }
//
//    private int square(int[] height, int left, int right) {
//        int res = 0 ;
//        int short_num = Math.min(height[left],height[right]);
//        for (int i = left+1; i < right; i++) {
//            res += short_num - height[i];
//        }
//        return res;
//    }
    @Test
    public void test(){
        int s = trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        System.out.println(s);
    }
    public int trap2(int[] height) {
        int[] stack = new int[height.length] ;
        int top = -1 ,  ans = 0 ;
        for (int i = 0; i < height.length; i++) {
            while (top>=0 && height[i]>height[stack[top]]){
                int topHeight = height[stack[top--]];
                if(top==-1) {
                    break;
                }
                int left = stack[top];
                ans += (Math.min(height[i], height[left]) - topHeight) *  (i - left - 1);
            }
            stack[++top] = i ;
        }
        return ans;
    }
}
