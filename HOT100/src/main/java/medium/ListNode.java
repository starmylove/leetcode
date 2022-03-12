package medium;

public class ListNode {
    public int key,val;
    public ListNode next,pre;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int key,int val) { this.key = key ; this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public ListNode(int val, ListNode next,ListNode pre) { this.val = val; this.next = next; this.pre = pre; }
    public ListNode(int key, int val, ListNode next,ListNode pre) { this.key = key ; this.val = val; this.next = next; this.pre = pre; }
}