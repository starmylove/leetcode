package middle;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Offer_31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0 ;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek() == popped[j]){
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test(){
//        System.out.println(validateStackSequences(new int[]{0, 2, 1}, new int[]{0, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1,2,3,4,5}, new int[]{04,5,3,2,1}));
    }
}