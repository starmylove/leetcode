package trick;

public class FloydHasLoop {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
      }
  }
  //142环形链表 II
    /*
    * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
    * 如果 pos 是 -1，则在该链表中没有环。
    * 注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。说明：不允许修改给定的链表。
    * */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null ;
        }
        ListNode slow = head , fast = head , ptr = null;
        while (fast!=null){
            if(fast.next == null){
                return null;
            }
            fast = fast.next.next ;
            slow = slow.next ;
            if(fast==slow){
                ptr = head ;
                while (ptr != slow){
                    slow = slow.next;
                    ptr= ptr.next;
                }
                break;
            }
        }
        return ptr;
    }
    //287. 寻找重复数
    /*
    * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），
    * 可知至少存在一个重复的整数。假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
    * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
    * */
    public int findDuplicate(int[] nums) {
        int slow = nums[0] , fast = nums[nums[0]];
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0 ;
        while (slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
