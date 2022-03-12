package easy;

public class num_234 {
    public boolean isPalindrome(ListNode head) {
        ListNode node = head ;
        int length = 0 ;
        while (node!=null) {
            length++;
            node = node.next;
        }
        if(length==1) {
            return true;
        }
        int[] nums = new int[length/2];
        node = head ;
        for (int i = 0; i < length / 2; i++) {
            nums[i] = node.val;
            node = node.next;
        }
        if(length%2!=0) {
            node = node.next;
        }
        for (int i = 0 ; i < length/2 ; i ++  ) {
            if(nums[length/2-1-i] != node.val) {
                return false;
            }
            node = node.next;
        }
        return true;
    }
}
