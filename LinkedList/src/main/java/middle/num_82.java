package middle;

import easy.ListNode;

public class num_82 {
    /* 删除排序链表中的重复元素 II
    * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，
    * 只保留原始链表中 没有重复出现 的数字。返回同样按升序排列的结果链表。
    * */

    public ListNode deleteDuplicates(ListNode head) {
        ListNode point = new ListNode(0) , p;
        point.next = head;
        p=point;
        while (p.next!=null){
            if(p.next.next==null) {
                break;
            }
            int num = p.next.val;
            if(p.next.next.val!=num){
                p=p.next;
            }else{
                ListNode temp = p.next;
                while(temp!=null&&temp.val==num) {
                    temp=temp.next;
                }
                p.next=temp;
            }
        }
        return point.next;
    }
}
