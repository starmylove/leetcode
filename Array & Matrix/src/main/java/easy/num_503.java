package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

public class num_503 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<int[]> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        int count = 0 ;
        for(int num : nums){
            max = Math.max(max,num);
        }
        Arrays.fill(ans,max+1);
        for (int num : nums) {
            if(num < max) {
                count++;
            }
        }
        int index = 1 ;
        stack.push(new int[]{nums[0],0});
        while (count>0){
            int num = nums[index];
            while (!stack.isEmpty()&&num>stack.peek()[0]){
                ans[stack.pop()[1]] = num;
                count--;
            }
            if(ans[index]==max+1) {
                stack.push(new int[]{num,index});
                ans[index]=max+2;
            }
            if(index == n-1) {
                index = 0 ;
            } else {
                index++;
            }
        }
        for (int i = 0; i < n; i++) {
            if(ans[i]==max+2 || ans[i]==max+1) {
                ans[i]=-1;
            }
        }
        return ans ;
    }
    public int[] nextGreaterElements1(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[i%n]>nums[stack.peek()]){
                ans[stack.pop()] = nums[i%n];
            }
            stack.push(i%n);
        }
        return ans ;
    }
        @Test
    public void test(){
        nextGreaterElements(new int[]{1});
    }
}













