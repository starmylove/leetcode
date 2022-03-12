package hard;


import easy.ListNode;

import java.util.PriorityQueue;

public class num_23 {
    /*
    * 给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。
    * */


    PriorityQueue<Status> queue = new PriorityQueue<>();
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        //维护一个优先级队列，用于存放各个链表的首元素，PriorityQueue的offer方法可以
        //按大小顺序插入（泛型元素要实现Comparable接口），PriorityQueue底层使用二叉堆来实现优先队列
        for(ListNode node : lists) {
            if(node!=null) {
                queue.offer(new Status(node.val, node));
            }
        }
        while(!queue.isEmpty()){
            tail.next = queue.poll().ptr;
            tail = tail.next;
            if(tail.next!=null) {
                queue.offer(new Status(tail.next.val,tail.next));
            }
        }
        return head.next;
    }



    class Status implements Comparable<Status>{
        int val;
        ListNode ptr ;

        public Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }
        //
        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }
}

