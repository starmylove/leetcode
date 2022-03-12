package hard;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class num_32 {
    //32. 最长有效括号
    /*
     *给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * */
    //这次不看答案，自己实现
    public int longestValidParentheses2(String s) {
        /*
        * 复盘一下思路
        *       保持栈底元素为最新的未匹配的)的下标（初始化时，在栈底加入-1），然后从左到右遍历字符串
        * 1.如果遇到(，入栈
        * 2.如果遇到)，将栈顶元素出栈
        *       如果栈已空，说明刚刚出栈的是右括号，此时用最新的)下标更新栈底。
        *       否则，用当前下标减去栈顶元素下标，即为当前匹配的有效括号长度，和maxLength比较，更新maxLength
        * */
        Stack<Integer> stack = new Stack<>();
        if(s.length()<2) {
            return 0;
        }
        int maxLength = 0;
        int length = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='(') {
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }
    //官方题解-照着敲
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        if(s.length()<2) {
            return 0;
        }
        int maxLength = 0;
        int length = 0 ;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else {
                    maxLength = Math.max(maxLength,i-stack.peek());
                }
            }
        }
        return maxLength;
    }
    //官方题解
    public int longestValidParentheses1(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
    @Test
    public void test(){
        String s = "()(()";
        int i = longestValidParentheses(s);
        System.out.println(i);
    }
}
