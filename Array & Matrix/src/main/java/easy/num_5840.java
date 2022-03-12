package easy;

import java.util.Stack;

public class num_5840 {
    public int minSwaps(String s) {
        if(s.length()==0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(stack.isEmpty() || chars[i] == '[') {
                stack.push(chars[i]);
            } else
                if(stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(']');
                }
        }
        int doubles = stack.size()/2;
        return (doubles&1)==1 ? doubles/2+1 :doubles/2;
    }
}
