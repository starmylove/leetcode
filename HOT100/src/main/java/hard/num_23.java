package hard;

import medium.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class num_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0) , cur = head ;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val ;
            }
        });
        for(ListNode listNode : lists){
            queue.offer(listNode);
        }
        while (!queue.isEmpty()){
            ListNode poll = queue.poll() ;
            cur.next = poll ;
            cur = cur.next ;
            if(poll.next!=null){
                queue.offer(poll.next);
            }
        }
        return head.next;
    }
}
