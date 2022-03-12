package easy;

import org.junit.Test;

import java.util.List;
import java.util.PriorityQueue;

public class MinStack {
    /*
    * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
    * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
    * */
    StackNode point , tail;
    PriorityQueue<Integer> queue;
    int min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        point = new StackNode(0,null,null);
        tail = point;
        queue = new PriorityQueue();
    }

    public void push(int val) {
        StackNode newNode = new StackNode(val,tail,null);
        tail.next = newNode ;
        tail = tail.next ;
        queue.offer(val) ;
        min = Math.min(queue.peek(),min) ;
    }

    public void pop() {
        if(tail!=point){
            queue.remove(tail.value);
            if(queue.size()!=0) {
                min = queue.peek();
            } else {
                min = Integer.MAX_VALUE;
            }
            StackNode temp = tail.pre;
            temp.next = null;
            tail = temp;
        }
    }

    public int top() {
        if(tail!=point) {
            return tail.value;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    public int getMin() {
        return min;
    }
    @Test
    public void test(){
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(3);
        stack.push(-2);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.getMin());
    }

}
