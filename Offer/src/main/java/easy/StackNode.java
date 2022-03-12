package easy;

public class StackNode {
    public int value;
    public StackNode pre ;

    public StackNode(int value, StackNode pre, StackNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public StackNode next ;
}
