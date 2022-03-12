package middle;

import easy.ListNode;

public class num_86 {
    /*
    * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，
    * 使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
    * 你应当 保留 两个分区中每个节点的初始相对位置。
    * */
    public ListNode partition(ListNode head, int x) {
        //维护3个链表，一张比x小，一张比x大，一张存放x值节点，均采用尾插法
        ListNode left = new ListNode(0) , lTail = left;
        ListNode right = new ListNode(0) , rTail = right;
        while (head!=null){
            if(head.val<x){
                lTail.next = head;
                lTail = lTail.next;
                head = head.next;
            }else{
                rTail.next = head;
                rTail = rTail.next;
                head= head.next;
            }
        }
        rTail.next=null;
        if(left.next!=null){
            lTail.next = right.next;
            return left.next;
        }
        else {
            return right.next;
        }


    }
}
