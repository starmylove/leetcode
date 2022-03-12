package easy;

public class num_83 {
    /*
    * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
    * 请你删除所有重复的元素，使每个元素 只出现一次 。
    * 返回同样按升序排列的结果链表。
    * */

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode p = head;
        while(p!=null){
            if(p.next==null) {
                break;
            }
            if(p.next.val==p.val){
                p.next=p.next.next;
            }
            else {
                p=p.next;
            }
        }
        return head;
    }
}
