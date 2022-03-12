package middle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class num_556 {
    //556. 下一个更大元素 III
    /*
     * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，
     * 并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
     * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     * */
    public int nextGreaterElement1(int n) {
        String s = String.valueOf(n);
        char[] array = s.toCharArray();

        int len = s.length();
        for (int i = len - 1; i > 0; i--) {
            if (array[i - 1] < array[i]) {
                for (int j = len - 1; j > i - 1; j--) {
                    if (array[j] > array[i - 1]) {
                        swap(array, i - 1, j);
                        Arrays.sort(array, i, len);
                        String res = new String(array);
                        long ans = Long.parseLong(res);
                        if (ans > Integer.MAX_VALUE){
                            return -1;
                        }
                        return (int)ans;
                    }
                }
            }
        }
        return -1;
    }
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();
        int length = nums.length;
        int left = length - 2 ,right = length-1;
        while (left >= 0 && nums[left] >= nums[left+1] ){
            left--;
        }
        if(left < 0) {
            return -1;
        }
        while (right >= 0 && nums[right] <= nums[left]) {
            right--;
        }
        swap(nums,left,right);
        reverse(nums,left+1,length-1);
        try{
            return Integer.parseInt(new String(nums));
        }catch (Exception e){
            return -1;
        }
    }

    private void reverse(char[] nums, int left, int right) {
        while (left<right) {
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    public int nextGreaterElement3(int n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        int length = arr.length;
        for (int i = length-2; i >=0 ; i--) {
            for (int j = length - 1 ; j > i ; j--) {
                if(arr[j] > arr[i]){
                    swap(arr,i,j);
                    Arrays.sort(arr,i+1,length);
                    long ans = Long.parseLong(new String(arr));
                    if(ans > Integer.MAX_VALUE) {
                        return -1;
                    } else {
                        return (int)ans;
                    }
                }
            }
        }
        return -1;
    }
    public void swap(char [] nums,int left , int right){
        char temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    @Test
    public void test(){
        nextGreaterElement(12443322);
    }
}











