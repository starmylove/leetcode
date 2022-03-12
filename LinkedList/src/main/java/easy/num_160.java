package easy;

public class num_160 {
    //方法1
    //可以用HashSet存储链表节点首先遍历链表 headA\textit{headA}headA，
    // 并将链表 headA\textit{headA}headA 中的每个节点加入哈希集合中。
    // 然后遍历链表 headB\textit{headB}headB，对于遍历到的每个节点，判断该节点是否在哈希集合中：
    //


    //方法2  相交链表
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0 , lenB=0 ;
        ListNode p = headA;
        while(p!=null){
            lenA++;
            p=p.next;
        }
        p=headB;
        while (p!=null){
            lenB++;
            p=p.next;
        }
        if(lenA < lenB){
            p = headA;
            headA = headB;
            headB = p;
            int temp = lenA;
            lenA = lenB;
            lenB = temp;
        }
        for (int i = 0; i < lenA - lenB; i++) {
            headA=headA.next;
        }
        while(headA!=null){
            if(headA==headB) {
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
