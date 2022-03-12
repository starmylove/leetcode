package easy;

import java.util.Stack;

public class Offer_9 {
    /*
    * 用两个栈实现一个队列。队列的声明如下，
    * 请实现它的两个函数 appendTail 和 deleteHead ，
    * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。
    * (若队列中没有元素，deleteHead 操作返回 -1 )
     * Your Offer_9 object will be instantiated and called as such:
     * Offer_9 obj = new Offer_9();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    public Offer_9() {
        stack1 = new Stack();//官方题解使用了LinkedList数据结构，效率更高一点
        stack2 = new Stack();
    }
    private Stack stack1 , stack2 ;
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        if(stack2.empty()) {
            return -1;
        }
        return (int)stack2.pop();
    }
}
