package easy;

public class Offer_6 {
    /*
    * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
    * */
    public static void main(String[] args) {

    }

    public int[] reversePrint(ListNode head) {
        if(head==null) {
            return new int[]{};
        }
        ListNode ans = new ListNode(0),p=head,temp;
        if(head.next==null) {
            return new int[]{head.val};
        }
        int sum = 0;
        while(p!=null){
            sum++;
            temp=p.next;
            p.next=ans.next;
            ans.next=p;
            p=temp;
        }
        int[] res = new int[sum];
        ans=ans.next;
        int i = 0 ;
        while(ans!=null){
            res[i++]=ans.val;
            ans=ans.next;
        }
        return res;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }