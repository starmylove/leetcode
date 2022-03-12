package easy;

import medium.ListNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class num_234 {
    public boolean isPalindrome(ListNode head) {
        if(head.next == null ){
            return true;
        }
        Deque<ListNode> stack = new LinkedList<>();
        int len = 1 ;
        ListNode cur = head.next ;
        while (cur != null){
            len ++ ;
            cur = cur.next;
        }
        for(int i = 0 ; i < len / 2  ;i ++){
            stack.push(head);
            head = head.next;
        }
        if(len % 2 == 1){
            head = head.next;
        }
        while (!stack.isEmpty()){
            if(stack.pop().val != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public boolean isPalindrome1(ListNode head) {
        if(head.next == null ){
            return true;
        }
        ListNode slow = head , fast = head.next ,half;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow =slow.next;
        }
        half = slow.next;
        half = reverseList(half);
        while (half != null){
            if(half.val != head.val){
                return false;
            }
            head = head.next;
            half = half.next;
        }
        return true;

    }
    public ListNode reverseList(ListNode head){
        ListNode pre = null ;
        while (head != null){
            ListNode temp = head.next ;
            head.next = pre ;
            pre = head ;
            head = temp ;
        }
        return pre;
    }
}
