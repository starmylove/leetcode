package easy;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class num_155 {
    //155. 最小栈
    /*
    * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
            push(x) —— 将元素 x 推入栈中。
            pop() —— 删除栈顶的元素。
            top() —— 获取栈顶元素。
            getMin() —— 检索栈中的最小元素。
    * */

//    Stack<Integer> stack ;
//    Stack<Integer> deque ;
    //LinkedList比用stack快
    LinkedList<Integer> stack ;
    LinkedList<Integer> deque ;
    public num_155() {
        stack = new LinkedList<Integer>();
        deque =  new LinkedList<Integer>();
    }
    public void push(int val) {
        if(deque.isEmpty()){
            deque.push(val);
        }else if(deque.peek() >= val){
            deque.push(val);
        }
        stack.push(val);
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
    public int getMin() {
        return deque.peek();
    }
    @Test
    public void test(){
        num_155 n = new num_155();
        n.push(512);
        n.push(-1024);
        n.push(-1024);
        n.push(512);
        n.pop();
        n.pop();
        n.pop();
        n.getMin();
    }
}
