package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer_30 {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> deque = new LinkedList<>();
    public Offer_30() {

    }

    public void push(int x) {
        stack.push(x);
        if(deque.isEmpty() || x <=deque.peek()) {
            deque.push(x);
        }
    }

    public void pop() {
        if(stack.peek().equals(deque.peek())) {
            deque.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return deque.peek();
    }
    @Test
    public void test(){
        Offer_30 o = new Offer_30();
        o.push(512);
        o.push(-1024);
        o.push(-1024);
        o.push(512);
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
        o.pop();
        System.out.println(o.min());
    }
}
