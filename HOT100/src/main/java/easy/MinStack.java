package easy;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> min = new ArrayDeque<>();
    Deque<Integer> stack = new ArrayDeque<>();
    public MinStack() {}

    public void push(int val) {
        if(min.isEmpty() || min.peek() >= val){
            min.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        int pop = stack.pop();
        if(min.peek() == pop){
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
