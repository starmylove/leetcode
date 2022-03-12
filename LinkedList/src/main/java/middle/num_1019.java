package middle;

import java.util.Stack;

public class num_1019 {
    //1019. 链表中的下一个更大节点
    public int[] nextLargerNodes(ListNode head) {
        ListNode p = head;
        int n = 0 ;
        while (p!=null){
            n++;
            p=p.next;
        }
        Stack<int[]> stack = new Stack<>();
        int index = 0 ;
        int[] ans = new int[n];
        p = head;
        for (int i = 0; i < n; i++) {
            int val = p.val;
            while (!stack.isEmpty() && val > stack.peek()[0]){
                ans[stack.pop()[1]] = val;
            }
            p = p.next;
            stack.push(new int[]{val,index++});
        }
        return ans;
    }
}
