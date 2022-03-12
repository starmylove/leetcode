package easy;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class num_496 {
    //496. 下一个更大元素 I
    /*
    * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，
    * 其中nums1 是 nums2 的子集。请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
    * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。
    * 如果不存在，对应位置输出 -1
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int n = nums1.length;
        int[] ans = new int[n];
        Arrays.fill(ans,-1);
        Map<Integer,Integer> map = new HashMap<>();
        int index = 0 ;
        for(int num : nums1){
            map.put(nums1[index],index++);
        }
        for(int num : nums2){
            while (!stack.isEmpty()&& num > stack.peek()) {
                ans[map.get(stack.pop())] = num ;
            }
            if(map.containsKey(num)){
                stack.push(num);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        nextGreaterElement(new int[]{4,1,2},new int[]{1,2,3,4});
    }
}










