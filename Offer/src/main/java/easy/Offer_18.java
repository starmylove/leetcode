package easy;

public class Offer_18 {
    /*
    * 给定单向链表的头指针和一个要删除的节点的值，
    * 定义一个函数删除该节点。返回删除后的链表的头节点
    * */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val) {
            return head.next;
        }
        ListNode p = head;
        while(p.next.val!=val) {
            p=p.next;
        }
        p.next=p.next.next;
        return head;
    }
}
