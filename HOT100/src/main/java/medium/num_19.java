package medium;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class num_19 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<Character>();
        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.offer(c);
            }else if (c == ')'){
                if(!stack.isEmpty() && stack.peekLast() == '('){
                    stack.removeLast();
                }else{
                    return false;
                }
            }else if (c == '}'){
                if(!stack.isEmpty() && stack.peekLast() == '{'){
                    stack.removeLast();
                }else{
                    return false;
                }
            }else if (c == ']'){
                if(!stack.isEmpty() && stack.peekLast() == '['){
                    stack.removeLast();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test(){
        isValid("{[]}");
    }
}
